package com.wcs.citimmo.service;

import com.wcs.citimmo.dto.RegisterDto;
import com.wcs.citimmo.dto.UserDto;
import com.wcs.citimmo.entity.User;
import com.wcs.citimmo.mappers.RegisterMapper;
import com.wcs.citimmo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RegisterMapper registerMapper;

    @Autowired
    ProfileService profileService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO : retrun the user. if null  throw UsernameNotFoundException
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user present with username : " + username);
        } else {
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
        }
    }

    public User save(UserDto userdto) {
        return userRepository.save(new User(userdto.getFirstName(), userdto.getLastName(), userdto.getEmail(), userdto.getPassword()));
    }

    public Boolean registerUser(RegisterDto registerDto){
        if(isAlreadyRegistered(registerDto.getEmail())){
            return Boolean.FALSE;
        }
        registerDto.setProfileDto(profileService.getUserProfileDto());
        userRepository.save(registerMapper.registerDtoToNewUser(registerDto));
        return Boolean.TRUE;
    }

    private boolean isAlreadyRegistered(String email){
        if(userRepository.findByEmail(email) != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
