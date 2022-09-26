package com.memely.memely.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.memely.memely.entity.Comment;
import com.memely.memely.entity.User;
import com.memely.memely.enums.Role;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<User> findAllByRole(Role role, Pageable pageable);
    Optional<User> findByUsername(String username);

    
    @Query(value="SELECT * FROM users as u JOIN followers ON followers.follower_id = u.id WHERE followers.followed_id = ?1 ;", nativeQuery = true)
    List<User> getUserFollowers(Long UserId);
    
  
    @Query(value="SELECT * FROM users as u JOIN followers ON followers.followed_id = u.id WHERE followers.follower_id = ?1 ;", nativeQuery = true)
    List<User> getUserFollowings(Long UserId);
    
    
    
    @Query(value="SELECT CASE WHEN EXISTS (SELECT TRUE FROM users as u JOIN followers ON followers.follower_id = u.id OR followers.followed_id = u.id WHERE followers.follower_id = ?1  AND u.username = ?2 ) THEN 'TRUE' ELSE 'FALSE' END;", nativeQuery = true)
    Boolean isFollowed(Long UserId, String username);
    
    @Query(value="SELECT CASE WHEN EXISTS (SELECT TRUE FROM users as u JOIN followers ON followers.follower_id = u.id OR followers.followed_id = u.id WHERE followers.followed_id = ?1  AND u.username = ?2 ) THEN 'TRUE' ELSE 'FALSE' END;", nativeQuery = true)
    Boolean isFollowing(Long UserId, String username);
    
    
//	Page<User> findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(String role, Boolean isMale, Boolean enabled, Pageable pageable);
//	Page<User> findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(String role, Boolean isMale, Boolean enabled, Pageable pageable);
}
