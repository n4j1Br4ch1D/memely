package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.CommentDto;
import com.memely.memely.entity.Comment;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.CommentRepository;
import com.memely.memely.response.CommentResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	private ModelMapper mapper;

	public CommentService(CommentRepository commentRepository, ModelMapper mapper) {
		this.commentRepository = commentRepository;
		this.mapper = mapper;
	}

	public CommentResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Comment> comments;
//		if (role == null && isMale == null && enabled == null) {
			comments = commentRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			memes = commentRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			memes = commentRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Comment> listOfComments = comments.getContent();
		List<CommentDto> commentContent = listOfComments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
		CommentResponse commentResponse = new CommentResponse();
		commentResponse.setContent(commentContent);
		commentResponse.setPageNo(comments.getNumber());
		commentResponse.setPageSize(comments.getSize());
		commentResponse.setTotalElements(comments.getTotalElements());
		commentResponse.setTotalPages(comments.getTotalPages());
		commentResponse.setLast(comments.isLast());
		return commentResponse;
	}

	public CommentDto getOne(long id) {
		Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
		return mapToDTO(comment);
	}

	public CommentDto create(CommentDto commentDto) {
		Comment comment = mapToEntity(commentDto);
		Comment newComment = commentRepository.save(comment);
		CommentDto commentResponse = mapToDTO(newComment);
		return commentResponse;
	}

	public CommentDto update(CommentDto commentDto, long id) {
		Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
		comment.setComment(commentDto.getComment());
		Comment updatedComment = commentRepository.save(comment);
		return mapToDTO(updatedComment);
	}

	public void delete(long id) {
		Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
		commentRepository.delete(comment);
	}

	private CommentDto mapToDTO(Comment comment) {
		CommentDto commentDto = mapper.map(comment, CommentDto.class);
		return commentDto;
	}

	private Comment mapToEntity(CommentDto commentDto) {
		Comment comment = mapper.map(commentDto, Comment.class);
		return comment;
	}

}
