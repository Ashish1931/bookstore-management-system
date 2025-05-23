//package com.bookstore.security;
//
//import com.bookstore.entity.User;
//import com.bookstore.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found with username: " + username));
//        return new CustomUserDetails(user);
//    }
//}
