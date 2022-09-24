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
import com.memely.memely.dto.MentionDto;
import com.memely.memely.entity.Mention;
import com.memely.memely.entity.Notification;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.response.MentionResponse;
import com.memely.memely.service.MentionService;
import com.memely.memely.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Mention Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/mentions")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class MentionController {

	@Autowired
	private MentionService mentionService;

	public MentionController(MentionService mentionService) {
		this.mentionService = mentionService;
	}
	
    @Operation(summary = "Get Mentions", description = "Get All Mentions & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<MentionDto>> getAll() {
		return ResponseEntity.ok(mentionService.getAll());
	}
    

    @Operation(summary = "Get Mention", description = "Get Mention By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<MentionDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(mentionService.getOne(id));
	}
    
    @Operation(summary = "Get Mentions of a User", description = "Get Mentions of a User By Id REST API")
	@GetMapping(value = "user/{userId}")
	public List<MentionDto> getOneByUserId(@PathVariable(name = "userId") long userId) {
		return mentionService.getbyUserId(userId);
	}

    @Operation(summary = "Create Mention", description = "Create New Mention REST API")
	@PostMapping
	public ResponseEntity<MentionDto> create(@Valid @RequestBody MentionDto mentionDto) {
		return new ResponseEntity<>(mentionService.create(mentionDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Mention", description = "Update Mention By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<MentionDto> update(@Valid @RequestBody MentionDto mentionDto, @PathVariable(name = "id") long id) {
		MentionDto mentionResponse = mentionService.update(mentionDto, id);
		return new ResponseEntity<>(mentionResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Mention", description = "Delete Mention By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		mentionService.delete(id);
		return new ResponseEntity<>("Mention entity deleted successfully.", HttpStatus.OK);
	}
        
}
