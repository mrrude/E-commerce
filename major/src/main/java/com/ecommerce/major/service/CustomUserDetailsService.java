package com.ecommerce.major.service;

import com.ecommerce.major.repository.UserRepository;
import com.ecommerce.major.model.CustomUserDetails;
import com.ecommerce.major.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {
     @Autowired
     UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<user> user1=userRepository.findUserByEmail(email);
        user1.orElseThrow(()->new  UsernameNotFoundException("user name no found"));
        return user1.map(CustomUserDetails::new).get();
    }
}
