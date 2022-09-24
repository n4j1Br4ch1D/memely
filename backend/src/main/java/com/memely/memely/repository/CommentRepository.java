package com.memely.memely.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.memely.memely.entity.Comment;
import com.memely.memely.entity.Mention;
import com.memely.memely.entity.Notification;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value="SELECT * FROM comments WHERE user_id = ?1 ;", nativeQuery = true)
    List<Comment> findAllByUserId(Long UserId);
}
