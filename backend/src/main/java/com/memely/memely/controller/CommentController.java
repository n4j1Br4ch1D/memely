package com.memely.memely.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.memely.memely.config.AppConstants;
import com.memely.memely.dto.CommentDto;
import com.memely.memely.entity.Comment;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.response.CommentResponse;
import com.memely.memely.service.CommentService;
import com.memely.memely.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Comment Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/comments")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class CommentController {

	@Autowired
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
    @Operation(summary = "Get Comments", description = "Get All Comments & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public CommentResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return commentService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}
    

    @Operation(summary = "Get Comment", description = "Get Comment By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<CommentDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(commentService.getOne(id));
	}

    @Operation(summary = "Create Comment", description = "Create New Comment REST API")
	@PostMapping
	public ResponseEntity<CommentDto> create(@Valid @RequestBody CommentDto commentDto) {
		return new ResponseEntity<>(commentService.create(commentDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Comment", description = "Update Comment By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<CommentDto> update(@Valid @RequestBody CommentDto commentDto, @PathVariable(name = "id") long id) {
		CommentDto commentResponse = commentService.update(commentDto, id);
		return new ResponseEntity<>(commentResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Comment", description = "Delete Comment By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		commentService.delete(id);
		return new ResponseEntity<>("Comment entity deleted successfully.", HttpStatus.OK);
	}
        
}
