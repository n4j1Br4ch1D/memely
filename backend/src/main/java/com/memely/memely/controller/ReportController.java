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
import com.memely.memely.dto.ReportDto;
import com.memely.memely.entity.Report;
import com.memely.memely.entity.Notification;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.response.ReportResponse;
import com.memely.memely.service.ReportService;
import com.memely.memely.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Report Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/reports")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class ReportController {

	@Autowired
	private ReportService reportService;

	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	
    @Operation(summary = "Get Reports", description = "Get All Reports & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<ReportDto>> getAll() {
		return ResponseEntity.ok(reportService.getAll());
	}
    

    @Operation(summary = "Get Report", description = "Get Report By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReportDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(reportService.getOne(id));
	}
    
    @Operation(summary = "Get Reports of a User", description = "Get Reports of a User By Id REST API")
	@GetMapping(value = "user/{userId}")
	public List<ReportDto> getOneByUserId(@PathVariable(name = "userId") long userId) {
		return reportService.getbyUserId(userId);
	}

    @Operation(summary = "Create Report", description = "Create New Report REST API")
	@PostMapping
	public ResponseEntity<ReportDto> create(@Valid @RequestBody ReportDto reportDto) {
		return new ResponseEntity<>(reportService.create(reportDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Report", description = "Update Report By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<ReportDto> update(@Valid @RequestBody ReportDto reportDto, @PathVariable(name = "id") long id) {
		ReportDto reportResponse = reportService.update(reportDto, id);
		return new ResponseEntity<>(reportResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Report", description = "Delete Report By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		reportService.delete(id);
		return new ResponseEntity<>("Report entity deleted successfully.", HttpStatus.OK);
	}
        
}
