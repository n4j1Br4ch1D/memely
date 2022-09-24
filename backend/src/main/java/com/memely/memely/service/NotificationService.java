package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.NotificationDto;
import com.memely.memely.entity.Notification;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.NotificationRepository;
import com.memely.memely.response.NotificationResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

	private NotificationRepository notificationRepository;
	private ModelMapper mapper;

	public NotificationService(NotificationRepository notificationRepository, ModelMapper mapper) {
		this.notificationRepository = notificationRepository;
		this.mapper = mapper;
	}

	public NotificationResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Notification> notifications;
//		if (role == null && isMale == null && enabled == null) {
			notifications = notificationRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			memes = notificationRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			memes = notificationRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Notification> listOfNotifications = notifications.getContent();
		List<NotificationDto> notificationContent = listOfNotifications.stream().map(notification -> mapToDTO(notification)).collect(Collectors.toList());
		NotificationResponse notificationResponse = new NotificationResponse();
		notificationResponse.setContent(notificationContent);
		notificationResponse.setPageNo(notifications.getNumber());
		notificationResponse.setPageSize(notifications.getSize());
		notificationResponse.setTotalElements(notifications.getTotalElements());
		notificationResponse.setTotalPages(notifications.getTotalPages());
		notificationResponse.setLast(notifications.isLast());
		return notificationResponse;
	}

	public NotificationDto getOne(long id) {
		Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification", "id", id));
		return mapToDTO(notification);
	}
	
	public List<Notification> getbyUserId(long userId) {
		List<Notification> notifications = notificationRepository.findAllByUserId(userId);
		return notifications;
	}
	

	public NotificationDto create(NotificationDto notificationDto) {
		Notification notification = mapToEntity(notificationDto);
		Notification newNotification = notificationRepository.save(notification);
		NotificationDto notificationResponse = mapToDTO(newNotification);
		return notificationResponse;
	}

	public NotificationDto update(NotificationDto notificationDto, long id) {
		Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification", "id", id));
		notification.setType(notificationDto.getType());
		Notification updatedNotification = notificationRepository.save(notification);
		return mapToDTO(updatedNotification);
	}

	public void delete(long id) {
		Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification", "id", id));
		notificationRepository.delete(notification);
	}

	private NotificationDto mapToDTO(Notification notification) {
		NotificationDto notificationDto = mapper.map(notification, NotificationDto.class);
		return notificationDto;
	}

	private Notification mapToEntity(NotificationDto notificationDto) {
		Notification notification = mapper.map(notificationDto, Notification.class);
		return notification;
	}

}
