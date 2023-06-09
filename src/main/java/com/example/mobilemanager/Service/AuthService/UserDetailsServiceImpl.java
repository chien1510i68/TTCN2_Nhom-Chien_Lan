package com.example.mobilemanager.Service.AuthService;

import com.example.mobilemanager.Entity.User;
import com.example.mobilemanager.Model.UserDetailsImpl;
import com.example.mobilemanager.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new RuntimeException("User not found"));
        return UserDetailsImpl.builder()
                .userName(user.getUserName())
                .id(user.getId())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .email(user.getEmail())
                .build();
    }
}
