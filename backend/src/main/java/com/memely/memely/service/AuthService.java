package com.memely.memely.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.memely.memely.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    final UserRepository userRepository;
    protected Optional<com.memely.memely.entity.User> user;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.memely.memely.entity.User> user = userRepository.findByUsernameOrEmail(username, username);
        this.user = user;
       List<GrantedAuthority> authorityList = new  ArrayList<>();

       authorityList.add(
       		new SimpleGrantedAuthority(user.get().getRole())
       		);
        
        User authUser = new User(user.get().getUsername(), user.get().getPassword(), authorityList);

        return authUser;

    }
    
    
    public Map<String, Object> authUser(String username){
        Map<String, Object> mapUser = new HashMap<String, Object>();
        mapUser.put("authUser", this.loadUserByUsername(username));
        mapUser.put("user", this.user);
        return mapUser;
    }

    
    public UserDetails createUserDetails(String username, String password) {
        Optional<com.memely.memely.entity.User> user = userRepository.findByUsernameOrEmail(username, username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("participant"));
        User nuser = new User(username, password, authorityList);
        return nuser;

    }
  
}
