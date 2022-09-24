package com.memely.memely.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.memely.memely.entity.Mention;
import com.memely.memely.entity.Report;


public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value="SELECT DISTINCT ON (r.meme_id) * FROM reports AS r LEFT JOIN memes AS m ON r.meme_id = m.id LEFT JOIN users AS u ON r.user_id = u.id;", nativeQuery = true)
	List<Report> findAllDistinct();
    
    
    @Query(value="SELECT * FROM reports AS r LEFT JOIN memes AS m ON r.meme_id = m.id LEFT JOIN users AS u ON r.user_id = u.id WHERE r.user_id= ?1 ;", nativeQuery = true)
    List<Report> findAllByUserId(Long UserId);
}
