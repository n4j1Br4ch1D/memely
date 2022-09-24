package com.memely.memely.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.memely.memely.entity.Notification;
import com.memely.memely.entity.User;
import com.memely.memely.enums.Role;


public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
    @Query(value="SELECT * FROM notifications WHERE user_id = ?1 ;", nativeQuery = true)
    List<Notification> findAllByUserId(Long UserId);

}
