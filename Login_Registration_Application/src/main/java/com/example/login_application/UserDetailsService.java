package com.example.login_application;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws
            Exception;
}
