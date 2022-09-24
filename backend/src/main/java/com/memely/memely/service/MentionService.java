package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.MentionDto;
import com.memely.memely.entity.Mention;
import com.memely.memely.entity.Notification;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.MentionRepository;
import com.memely.memely.response.MentionResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentionService {

	private MentionRepository mentionRepository;
	private ModelMapper mapper;

	public MentionService(MentionRepository mentionRepository, ModelMapper mapper) {
		this.mentionRepository = mentionRepository;
		this.mapper = mapper;
	}

	public List<MentionDto> getAll() {
		List<Mention> mentions = mentionRepository.findAllDistinct();
		List<MentionDto> mentionContent = mentions.stream().map(mention -> mapToDTO(mention)).collect(Collectors.toList());
		return mentionContent;
	}

	public MentionDto getOne(long id) {
		Mention mention = mentionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mention", "id", id));
		return mapToDTO(mention);
	}
	
	public List<MentionDto> getbyUserId(long userId) {
		List<Mention> mentions = mentionRepository.findAllByUserId(userId);
		List<MentionDto> mentionContent = mentions.stream().map(mention -> mapToDTO(mention)).collect(Collectors.toList());
		return mentionContent;
	}

	public MentionDto create(MentionDto mentionDto) {
		Mention mention = mapToEntity(mentionDto);
		Mention newMention = mentionRepository.save(mention);
		MentionDto mentionResponse = mapToDTO(newMention);
		return mentionResponse;
	}

	public MentionDto update(MentionDto mentionDto, long id) {
		Mention mention = mentionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mention", "id", id));
//		mention.setMention(mentionDto.getMention());
		Mention updatedMention = mentionRepository.save(mention);
		return mapToDTO(updatedMention);
	}

	public void delete(long id) {
		Mention mention = mentionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mention", "id", id));
		mentionRepository.delete(mention);
	}

	private MentionDto mapToDTO(Mention mention) {
		MentionDto mentionDto = mapper.map(mention, MentionDto.class);
		return mentionDto;
	}

	private Mention mapToEntity(MentionDto mentionDto) {
		Mention mention = mapper.map(mentionDto, Mention.class);
		return mention;
	}

}
