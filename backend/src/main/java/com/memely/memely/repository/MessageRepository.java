package com.memely.memely.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.memely.memely.entity.Message;
import com.memely.memely.entity.Notification;
import com.memely.memely.entity.User;


public interface MessageRepository extends JpaRepository<Message, Long> {
	
	// Still has an issue !solved like this 
    @Query(value="SELECT DISTINCT ON (m.id) * FROM messages AS m JOIN users as u ON m.reciver_id = 2  OR m.sender_id = 2  WHERE (m.sender_id = 1 OR m.sender_id = 2 ) AND (m.reciver_id = 1 OR  m.reciver_id = 2);", nativeQuery = true)
    List<Message> findMessages(Long sender, Long reciver, Long sender2, Long reciver2);

    
    @Query(value="SELECT DISTINCT ON (u.id) u.* FROM users AS u JOIN messages as m ON u.id = m.reciver_id OR u.id = m.sender_id WHERE m.sender_id = ?1 OR m.reciver_id = ?1 ;", nativeQuery = true)
    List<Object[]> findMessagesFriends(Long UserId);

}
