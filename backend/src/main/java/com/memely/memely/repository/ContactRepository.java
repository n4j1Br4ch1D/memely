package com.memely.memely.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.memely.memely.entity.Contact;
import com.memely.memely.entity.Notification;


public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query(value="SELECT * FROM contacts WHERE user_id = ?1 ;", nativeQuery = true)
    List<Contact> findAllByUserId(Long UserId);
}
