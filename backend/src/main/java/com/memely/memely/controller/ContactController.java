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
import com.memely.memely.dto.ContactDto;
import com.memely.memely.entity.Contact;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.response.ContactResponse;
import com.memely.memely.service.ContactService;
import com.memely.memely.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Contact Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/contacts")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class ContactController {

	@Autowired
	private ContactService contactService;

	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
    @Operation(summary = "Get Contacts", description = "Get All Contacts & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ContactResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return contactService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}
    

    @Operation(summary = "Get Contact", description = "Get Contact By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContactDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(contactService.getOne(id));
	}
    
    @Operation(summary = "Get Contacts of a User", description = "Get Contacts of a User By Id REST API")
	@GetMapping(value = "user/{userId}")
	public ResponseEntity<List<Contact>> getOneByUserId(@PathVariable(name = "userId") long userId) {
		return ResponseEntity.ok(contactService.getbyUserId(userId));
	}

    @Operation(summary = "Create Contact", description = "Create New Contact REST API")
	@PostMapping
	public ResponseEntity<ContactDto> create(@Valid @RequestBody ContactDto contactDto) {
		return new ResponseEntity<>(contactService.create(contactDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Contact", description = "Update Contact By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<ContactDto> update(@Valid @RequestBody ContactDto contactDto, @PathVariable(name = "id") long id) {
		ContactDto contactResponse = contactService.update(contactDto, id);
		return new ResponseEntity<>(contactResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Contact", description = "Delete Contact By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		contactService.delete(id);
		return new ResponseEntity<>("Contact entity deleted successfully.", HttpStatus.OK);
	}
        
}
