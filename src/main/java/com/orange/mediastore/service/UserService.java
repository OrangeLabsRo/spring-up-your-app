package com.orange.mediastore.service;

import com.orange.mediastore.model.Media;
import com.orange.mediastore.model.User;
import com.orange.mediastore.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found in DB!");
        }
        return user;
    }

    public void register(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null) {
            throw new RuntimeException("Username already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            throw new RuntimeException("No user is logged in!");
        }
        String name = authentication.getName();
        return userRepository.findByUsername(name);
    }

}
