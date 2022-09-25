package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.TagDto;
import com.memely.memely.entity.Tag;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.TagRepository;
import com.memely.memely.response.TagResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

	private TagRepository tagRepository;
	private ModelMapper mapper;

	public TagService(TagRepository tagRepository, ModelMapper mapper) {
		this.tagRepository = tagRepository;
		this.mapper = mapper;
	}

	public TagResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Tag> tags;
//		if (role == null && isMale == null && enabled == null) {
			tags = tagRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			memes = tagRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			memes = tagRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Tag> listOfTags = tags.getContent();
		List<TagDto> tagContent = listOfTags.stream().map(tag -> mapToDTO(tag)).collect(Collectors.toList());
		TagResponse tagResponse = new TagResponse();
		tagResponse.setContent(tagContent);
		tagResponse.setPageNo(tags.getNumber());
		tagResponse.setPageSize(tags.getSize());
		tagResponse.setTotalElements(tags.getTotalElements());
		tagResponse.setTotalPages(tags.getTotalPages());
		tagResponse.setLast(tags.isLast());
		return tagResponse;
	}

	public TagDto getOne(long id) {
		Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
		return mapToDTO(tag);
	}
	
	public TagDto create(TagDto tagDto) {
		Tag tag = mapToEntity(tagDto);
		Tag newTag = tagRepository.save(tag);
		TagDto tagResponse = mapToDTO(newTag);
		return tagResponse;
	}

	public TagDto update(TagDto tagDto, long id) {
		Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
		tag.setName(tagDto.getName());
		Tag updatedTag = tagRepository.save(tag);
		return mapToDTO(updatedTag);
	}

	public void delete(long id) {
		Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
		tagRepository.delete(tag);
	}

	private TagDto mapToDTO(Tag tag) {
		TagDto tagDto = mapper.map(tag, TagDto.class);
		return tagDto;
	}

	private Tag mapToEntity(TagDto tagDto) {
		Tag tag = mapper.map(tagDto, Tag.class);
		return tag;
	}

}
