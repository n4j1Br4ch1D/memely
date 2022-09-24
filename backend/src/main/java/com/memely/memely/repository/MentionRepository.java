package com.memely.memely.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.memely.memely.entity.Comment;
import com.memely.memely.entity.Mention;


public interface MentionRepository extends JpaRepository<Mention, Long> {
	
    @Query(value="SELECT DISTINCT ON (m.meme_id, m.comment_id) * FROM mentions AS m LEFT JOIN memes AS me ON m.meme_id = me.id LEFT JOIN comments AS c ON m.comment_id = c.id", nativeQuery = true)
	List<Mention> findAllDistinct();
    
    
    @Query(value="SELECT DISTINCT ON (m.meme_id, m.comment_id) * FROM mentions AS m LEFT JOIN memes AS me ON m.meme_id = me.id LEFT JOIN comments AS c ON m.comment_id = c.id WHERE m.taggeduser_id= ?1 ;", nativeQuery = true)
    List<Mention> findAllByUserId(Long UserId);
}
