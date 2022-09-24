package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.ReportDto;
import com.memely.memely.entity.Report;
import com.memely.memely.entity.Notification;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.ReportRepository;
import com.memely.memely.response.ReportResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

	private ReportRepository reportRepository;
	private ModelMapper mapper;

	public ReportService(ReportRepository reportRepository, ModelMapper mapper) {
		this.reportRepository = reportRepository;
		this.mapper = mapper;
	}

	public List<ReportDto> getAll() {
		List<Report> reports = reportRepository.findAllDistinct();
		List<ReportDto> reportContent = reports.stream().map(report -> mapToDTO(report)).collect(Collectors.toList());
		return reportContent;
	}

	public ReportDto getOne(long id) {
		Report report = reportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report", "id", id));
		return mapToDTO(report);
	}
	
	public List<ReportDto> getbyUserId(long userId) {
		List<Report> reports = reportRepository.findAllByUserId(userId);
		List<ReportDto> reportContent = reports.stream().map(report -> mapToDTO(report)).collect(Collectors.toList());
		return reportContent;
	}

	public ReportDto create(ReportDto reportDto) {
		Report report = mapToEntity(reportDto);
		Report newReport = reportRepository.save(report);
		ReportDto reportResponse = mapToDTO(newReport);
		return reportResponse;
	}

	public ReportDto update(ReportDto reportDto, long id) {
		Report report = reportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report", "id", id));
//		report.setReport(reportDto.getReport());
		Report updatedReport = reportRepository.save(report);
		return mapToDTO(updatedReport);
	}

	public void delete(long id) {
		Report report = reportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report", "id", id));
		reportRepository.delete(report);
	}

	private ReportDto mapToDTO(Report report) {
		ReportDto reportDto = mapper.map(report, ReportDto.class);
		return reportDto;
	}

	private Report mapToEntity(ReportDto reportDto) {
		Report report = mapper.map(reportDto, Report.class);
		return report;
	}

}
