package com.wcs.citimmo.service;

import com.wcs.citimmo.dto.UserDto;
import com.wcs.citimmo.entity.User;
import com.wcs.citimmo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service("userService")
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) { this.userRepository = userRepository;  }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO : retrun the user. if null  throw UsernameNotFoundException
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user present with username : " + username);
        } else {
            return user;
        }
    }

    public User save(UserDto userdto) {
        return userRepository.save(new User(userdto.getFirstName(), userdto.getLastName(), userdto.getEmail(), userdto.getPassword()));
    }
}
