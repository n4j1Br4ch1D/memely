package com.memely.memely.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.memely.memely.dto.UserDto;
import com.memely.memely.entity.User;
import com.memely.memely.enums.FilterCond;
import com.memely.memely.enums.Role;
import com.memely.memely.exception.ResourceNotFoundException;
import com.memely.memely.repository.UserRepository;
import com.memely.memely.response.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

	private UserRepository userRepository;
	private ModelMapper mapper;

	public UserService(UserRepository userRepository, ModelMapper mapper) {
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	public UserResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<User> users;
//		if (role == null && isMale == null && enabled == null) {
			users = userRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			users = userRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			users = userRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<User> listOfUsers = users.getContent();
		List<UserDto> userContent = listOfUsers.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());
		UserResponse userResponse = new UserResponse();
		userResponse.setContent(userContent);
		userResponse.setPageNo(users.getNumber());
		userResponse.setPageSize(users.getSize());
		userResponse.setTotalElements(users.getTotalElements());
		userResponse.setTotalPages(users.getTotalPages());
		userResponse.setLast(users.isLast());
		return userResponse;
	}

	public List<UserDto> getUserFollowers(long id) {
		List<User> followers = userRepository.getUserFollowers(id);
		List<UserDto> users = followers.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());
		return users;
	}
	
	public List<UserDto> getUserFollowing(long id) {
		List<User> following= userRepository.getUserFollowings(id);
		List<UserDto> users = following.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());
		return users;
	}
	
	public UserDto getOne(long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return mapToDTO(user);
	}

	public UserDto getOneByUsername(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		return mapToDTO(user);
	}
	
	public UserDto getOneByUsernameByReqUserId(Long requestUserId, String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		user.setFollowed(userRepository.isFollowed(requestUserId, username) || false);
		user.setFollowing(userRepository.isFollowing(requestUserId, username) || false);
		return mapToDTO(user);
	}
	
	public UserDto create(UserDto userDto) {
		User user = mapToEntity(userDto);
		User newUser = userRepository.save(user);
		UserDto userResponse = mapToDTO(newUser);
		return userResponse;
	}

	public UserDto update(UserDto userDto, long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		user.setFullName(userDto.getFullName());
		User updatedUser = userRepository.save(user);
		return mapToDTO(updatedUser);
	}

	public void delete(long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.delete(user);
	}

	private UserDto mapToDTO(User user) {
		UserDto userDto = mapper.map(user, UserDto.class);
		return userDto;
	}

	private User mapToEntity(UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		return user;
	}

}
