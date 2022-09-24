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
import com.memely.memely.dto.NotificationDto;
import com.memely.memely.entity.Notification;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.response.NotificationResponse;
import com.memely.memely.service.NotificationService;
import com.memely.memely.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Notification Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/notifications")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
    @Operation(summary = "Get Notifications", description = "Get All Notifications & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public NotificationResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return notificationService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}
    

    @Operation(summary = "Get Notification", description = "Get Notification By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<NotificationDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(notificationService.getOne(id));
	}
    
    @Operation(summary = "Get Notifications of a User", description = "Get Notifications of a User By Id REST API")
	@GetMapping(value = "user/{userId}")
	public ResponseEntity<List<Notification>> getOneByUserId(@PathVariable(name = "userId") long userId) {
		return ResponseEntity.ok(notificationService.getbyUserId(userId));
	}

    @Operation(summary = "Create Notification", description = "Create New Notification REST API")
	@PostMapping
	public ResponseEntity<NotificationDto> create(@Valid @RequestBody NotificationDto notificationDto) {
		return new ResponseEntity<>(notificationService.create(notificationDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Notification", description = "Update Notification By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<NotificationDto> update(@Valid @RequestBody NotificationDto notificationDto, @PathVariable(name = "id") long id) {
		NotificationDto notificationResponse = notificationService.update(notificationDto, id);
		return new ResponseEntity<>(notificationResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Notification", description = "Delete Notification By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		notificationService.delete(id);
		return new ResponseEntity<>("Notification entity deleted successfully.", HttpStatus.OK);
	}
        
}
