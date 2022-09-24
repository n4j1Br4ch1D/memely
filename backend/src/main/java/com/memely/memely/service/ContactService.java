package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.ContactDto;
import com.memely.memely.entity.Contact;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.ContactRepository;
import com.memely.memely.response.ContactResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

	private ContactRepository contactRepository;
	private ModelMapper mapper;

	public ContactService(ContactRepository contactRepository, ModelMapper mapper) {
		this.contactRepository = contactRepository;
		this.mapper = mapper;
	}

	public ContactResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Contact> contacts;
//		if (role == null && isMale == null && enabled == null) {
			contacts = contactRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			memes = contactRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			memes = contactRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Contact> listOfContacts = contacts.getContent();
		List<ContactDto> contactContent = listOfContacts.stream().map(contact -> mapToDTO(contact)).collect(Collectors.toList());
		ContactResponse contactResponse = new ContactResponse();
		contactResponse.setContent(contactContent);
		contactResponse.setPageNo(contacts.getNumber());
		contactResponse.setPageSize(contacts.getSize());
		contactResponse.setTotalElements(contacts.getTotalElements());
		contactResponse.setTotalPages(contacts.getTotalPages());
		contactResponse.setLast(contacts.isLast());
		return contactResponse;
	}

	public ContactDto getOne(long id) {
		Contact contact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
		return mapToDTO(contact);
	}
	
	public List<Contact> getbyUserId(long userId) {
		List<Contact> contacts = contactRepository.findAllByUserId(userId);
		return contacts;
	}
	
	public ContactDto create(ContactDto contactDto) {
		Contact contact = mapToEntity(contactDto);
		Contact newContact = contactRepository.save(contact);
		ContactDto contactResponse = mapToDTO(newContact);
		return contactResponse;
	}

	public ContactDto update(ContactDto contactDto, long id) {
		Contact contact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
		contact.setMessage(contactDto.getMessage());
		Contact updatedContact = contactRepository.save(contact);
		return mapToDTO(updatedContact);
	}

	public void delete(long id) {
		Contact contact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
		contactRepository.delete(contact);
	}

	private ContactDto mapToDTO(Contact contact) {
		ContactDto contactDto = mapper.map(contact, ContactDto.class);
		return contactDto;
	}

	private Contact mapToEntity(ContactDto contactDto) {
		Contact contact = mapper.map(contactDto, Contact.class);
		return contact;
	}

}
