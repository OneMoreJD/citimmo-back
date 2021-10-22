package com.wcs.citimmo.controller;

import com.wcs.citimmo.config.JwtTokenUtil;
import com.wcs.citimmo.dto.JwtRequest;
import com.wcs.citimmo.dto.JwtResponse;
import com.wcs.citimmo.dto.UserDto;
import com.wcs.citimmo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userDetailsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

       try {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));

        } catch (BadCredentialsException e) {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(HttpStatus.UNAUTHORIZED.getReasonPhrase() + e.getMessage());
        } catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.LOCKED).body(HttpStatus.LOCKED.getReasonPhrase() + " - " + e.getMessage());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (LockedException e) {
           return ResponseEntity.status(HttpStatus.LOCKED).body(HttpStatus.LOCKED.getReasonPhrase() + " - " + e.getMessage());
        } catch (AccountExpiredException e) {
           return ResponseEntity.status(HttpStatus.LOCKED).body(HttpStatus.LOCKED.getReasonPhrase() + " - " + e.getMessage());
        }

    }

    @RequestMapping(value = "/registering", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

}

