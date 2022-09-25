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
import com.memely.memely.dto.TagDto;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.response.TagResponse;
import com.memely.memely.service.TagService;
import com.memely.memely.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tag Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/tags")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class TagController {

	@Autowired
	private TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}
	
    @Operation(summary = "Get Tags", description = "Get All Tags & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public TagResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return tagService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}
    

    @Operation(summary = "Get Tag", description = "Get Tag By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<TagDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(tagService.getOne(id));
	}
    
    @Operation(summary = "Create Tag", description = "Create New Tag REST API")
	@PostMapping
	public ResponseEntity<TagDto> create(@Valid @RequestBody TagDto tagDto) {
		return new ResponseEntity<>(tagService.create(tagDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Tag", description = "Update Tag By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<TagDto> update(@Valid @RequestBody TagDto tagDto, @PathVariable(name = "id") long id) {
		TagDto tagResponse = tagService.update(tagDto, id);
		return new ResponseEntity<>(tagResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Tag", description = "Delete Tag By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		tagService.delete(id);
		return new ResponseEntity<>("Tag entity deleted successfully.", HttpStatus.OK);
	}
        
}
