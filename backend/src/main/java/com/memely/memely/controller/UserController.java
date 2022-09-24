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
import com.memely.memely.dto.UserDto;
import com.memely.memely.entity.Meme;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.response.UserResponse;
import com.memely.memely.service.UserService;
import com.memely.memely.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
    @Operation(summary = "Get Users", description = "Get All Users & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public UserResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return userService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}
    
    
    @Operation(summary = "Get User", description = "Get User By Id REST API")
	@GetMapping(value = "/{id}/followers")
	public List<UserDto> getUserFollwers(@PathVariable(name = "id") long id) {
		return userService.getUserFollowers(id);
	}
    
    @Operation(summary = "Get User", description = "Get User By Id REST API")
	@GetMapping(value = "/{id}/following")
	public List<UserDto> getUserFollwing(@PathVariable(name = "id") long id) {
		return userService.getUserFollowing(id);
	}
    
    @Operation(summary = "Get User", description = "Get User By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(userService.getOne(id));
	}

    @Operation(summary = "Create User", description = "Create New User REST API")
	@PostMapping
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update User", description = "Update User By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@Valid @RequestBody UserDto userDto, @PathVariable(name = "id") long id) {
		UserDto userResponse = userService.update(userDto, id);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete User", description = "Delete User By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		userService.delete(id);
		return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
	}
        
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Role.class, new EnumConverter(Role.class));
    }
    
}
