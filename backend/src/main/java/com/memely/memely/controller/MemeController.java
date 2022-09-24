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
import com.memely.memely.dto.MemeDto;
import com.memely.memely.entity.Meme;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.response.MemeResponse;
import com.memely.memely.service.MemeService;
import com.memely.memely.service.UserService;
import com.memely.memely.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Meme Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/memes")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class MemeController {

	@Autowired
	private MemeService memeService;

	public MemeController(MemeService memeService, UserService userService) {
		this.memeService = memeService;
	}
	
    @Operation(summary = "Get Memes", description = "Get All Memes & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public MemeResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return memeService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}
    
	@GetMapping(value="search/{keywords}") //Next Version add pagination & filtering
	public List<Meme> searchMemes(@PathVariable(name = "keywords") String keywords) {
		return memeService.searchMemes(keywords);
	}
	
	@GetMapping(value="username/{username}") //Next Version add pagination & filtering
	public List<Meme> getMemes(@PathVariable(name = "username") String username) {
		return memeService.getMemesByUsername(username);
	}
	
	@GetMapping(value="tag/{tag}") //Next Version add pagination & filtering
	public List<Meme> getMemesbyTag(@PathVariable(name = "tag") String tag) {
		return memeService.getMemesByTag(tag);
	}
	
	@GetMapping(value="stories") //Next Version add pagination & filtering
	public List<Meme> getStories() {
		return memeService.getStories();
	}
	
	@GetMapping(value="favorites") //Next Version add pagination & filtering
	public List<Meme> getAllFavorites() {
		return memeService.getAllFavorites();
	}
	
	@GetMapping(value="{id}/favorites") //Next Version add pagination & filtering
	public List<Meme> getUserFavorites(@PathVariable(name = "id") Long id) {
//		return userService.getOne(id).getFavorites();
		return memeService.getUserFavorites(id);
	}
	
	@GetMapping(value="reactions") //Next Version add pagination & filtering
	public List<Meme> getAllReactions() {
		return memeService.getAllReactions();
	}
	
	@GetMapping(value="{id}/reactions") //Next Version add pagination & filtering
	public List<Meme> getUserReactions(@PathVariable(name = "id") Long id) {
//		return userService.getOne(id).getFavorites();
		return memeService.getUserReactions(id);
	}
	

    @Operation(summary = "Get Meme", description = "Get Meme By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<MemeDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(memeService.getOne(id));
	}

    @Operation(summary = "Create Meme", description = "Create New Meme REST API")
	@PostMapping
	public ResponseEntity<MemeDto> create(@Valid @RequestBody MemeDto memeDto) {
		return new ResponseEntity<>(memeService.create(memeDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Meme", description = "Update Meme By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<MemeDto> update(@Valid @RequestBody MemeDto memeDto, @PathVariable(name = "id") long id) {
		MemeDto memeResponse = memeService.update(memeDto, id);
		return new ResponseEntity<>(memeResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Meme", description = "Delete Meme By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		memeService.delete(id);
		return new ResponseEntity<>("Meme entity deleted successfully.", HttpStatus.OK);
	}
        
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Role.class, new EnumConverter(Role.class));
    }
    
}
