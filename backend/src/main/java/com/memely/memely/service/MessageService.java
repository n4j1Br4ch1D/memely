package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.MessageDto;
import com.memely.memely.entity.Message;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.MessageRepository;
import com.memely.memely.response.MessageResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

	private MessageRepository messageRepository;
	private ModelMapper mapper;

	public MessageService(MessageRepository messageRepository, ModelMapper mapper) {
		this.messageRepository = messageRepository;
		this.mapper = mapper;
	}

	public MessageResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Message> messages;
//		if (role == null && isMale == null && enabled == null) {
			messages = messageRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			memes = messageRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			memes = messageRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Message> listOfMessages = messages.getContent();
		List<MessageDto> messageContent = listOfMessages.stream().map(message -> mapToDTO(message)).collect(Collectors.toList());
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setContent(messageContent);
		messageResponse.setPageNo(messages.getNumber());
		messageResponse.setPageSize(messages.getSize());
		messageResponse.setTotalElements(messages.getTotalElements());
		messageResponse.setTotalPages(messages.getTotalPages());
		messageResponse.setLast(messages.isLast());
		return messageResponse;
	}

	public MessageDto getOne(long id) {
		Message message = messageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message", "id", id));
		return mapToDTO(message);
	}
	
	
	public List<Message> getMessages(long userId, Long friendId) {
//		 List<Long> ids = new ArrayList<>();
//		    ids.add(userId);
//		    ids.add(friendId);
		
		Long userId2  = 1L;
		Long friendId2 = 2L;
		List<Message> messages = messageRepository.findMessages(userId, friendId, userId2, friendId2);
		return messages;
	}
	
	public List<User> getMessagesFriends(long userId) {
		List<Object[]> users = messageRepository.findMessagesFriends(userId);
		List<User> friends = users.stream().map(User::new).collect(Collectors.toList());
		return friends;
	}
	
	public MessageDto create(MessageDto messageDto) {
		Message message = mapToEntity(messageDto);
		Message newMessage = messageRepository.save(message);
		MessageDto messageResponse = mapToDTO(newMessage);
		return messageResponse;
	}

	public MessageDto update(MessageDto messageDto, long id) {
		Message message = messageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message", "id", id));
		message.setContent(messageDto.getContent());
		Message updatedMessage = messageRepository.save(message);
		return mapToDTO(updatedMessage);
	}

	public void delete(long id) {
		Message message = messageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message", "id", id));
		messageRepository.delete(message);
	}

	private MessageDto mapToDTO(Message message) {
		MessageDto messageDto = mapper.map(message, MessageDto.class);
		return messageDto;
	}

	private Message mapToEntity(MessageDto messageDto) {
		Message message = mapper.map(messageDto, Message.class);
		return message;
	}

}
