package com.memely.memely.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.memely.memely.entity.Meme;
import com.memely.memely.entity.Report;
import com.memely.memely.entity.User;
import com.memely.memely.enums.Role;


public interface MemeRepository extends JpaRepository<Meme, Long> {
	
	@Query(value="SELECT m.* FROM memes as m LEFT JOIN users ON m.user_id = users.id where users.username = ?1 ;", nativeQuery = true)
    List<Meme> findAllByUserUsername(String username);

	@Query(value="SELECT m.* FROM memes as m LEFT JOIN users ON m.user_id = users.id where users.id = ?1 ;", nativeQuery = true)
    List<Meme> findAllByUserId(Long userId);
	
    List<Meme> findAllByStory(Boolean story);

    List<Meme> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
	
    @Query(value="SELECT m.* FROM memes as m CROSS JOIN tags INNER JOIN meme_tags ON meme_tags.meme_id = m.id AND meme_tags.tag_id = tags.id WHERE tags.name = ?1 ;", nativeQuery = true)
    List<Meme> findAllByTagName(String tag);

    @Query(value="SELECT DISTINCT m.* FROM memes as m INNER JOIN favorites ON favorites.meme_id = m.id", nativeQuery = true)
    List<Meme> getAllFavorites();
	
    @Query(value="SELECT m.* FROM memes as m INNER JOIN favorites ON favorites.meme_id = m.id where favorites.user_id = ?1 ;", nativeQuery = true)
    List<Meme> getUserFavorites(Long id);
    
    @Query(value="SELECT DISTINCT m.* FROM memes as m INNER JOIN reactions ON reactions.meme_id = m.id", nativeQuery = true)
    List<Meme> getAllReactions();
	
    @Query(value="SELECT m.* FROM memes as m INNER JOIN reactions ON reactions.meme_id = m.id where reactions.user_id = ?1", nativeQuery = true)
    List<Meme> getUserReactions(Long id);
    
    
    @Query(value="SELECT DISTINCT ON (r.meme_id) * FROM reports AS r LEFT JOIN memes AS m ON r.meme_id = m.id LEFT JOIN users AS u ON r.user_id = u.id;", nativeQuery = true)
	List<Meme> getAllReports();
    
    @Query(value="SELECT * FROM reports AS r LEFT JOIN memes AS m ON r.meme_id = m.id LEFT JOIN users AS u ON r.user_id = u.id WHERE r.user_id= ?1 ;", nativeQuery = true)
    List<Meme> getUserReports(Long UserId);

    @Query(value="SELECT * FROM memes where memes.user_id = ?1 AND memes.story = true;", nativeQuery = true)
	List<Meme> getUserStories(Long userId);
}
