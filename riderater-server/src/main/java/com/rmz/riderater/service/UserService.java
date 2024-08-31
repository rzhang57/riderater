package com.rmz.riderater.service;

import com.rmz.riderater.model.User;
import com.rmz.riderater.repository.AuthRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostConstruct
//    public void init() {
//        if (authRepo.count() == 0) {
//            User user = new User();
//            user.setUsername("admin");
//            user.setPassword(passwordEncoder.encode("ADMIN"));
//            user.setRole("ROLE_ADMIN");
//            authRepo.save(user);
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString()))
        );
    }


}
