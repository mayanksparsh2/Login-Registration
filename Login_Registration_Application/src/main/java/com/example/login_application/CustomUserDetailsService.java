package com.example.login_application;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            return null;
        }
        return new CustomUserDetails(user);
    }

}
