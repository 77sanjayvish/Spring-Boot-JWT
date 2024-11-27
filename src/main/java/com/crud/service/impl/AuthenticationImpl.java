package com.crud.service.impl;

import com.crud.entity.User;
import com.crud.enums.Role;
import com.crud.payload.AuthenticationResponse;
import com.crud.payload.LoginDto;
import com.crud.payload.RefresshTokenResponse;
import com.crud.payload.SignUpDto;
import com.crud.repository.UserRepository;
import com.crud.service.AuthenticationService;
import com.crud.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service

public class AuthenticationImpl implements AuthenticationService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private  JwtService jwtService;

    public User signup(SignUpDto signUpDto){

        User user = new User();
        user.setFirstname(signUpDto.getFirstname());
        user.setLastname(signUpDto.getLastname());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole(signUpDto.getRole());
       return  userRepository.save(user);
    }

    @Override
    public AuthenticationResponse login(LoginDto loginDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
            var user = userRepository.findByEmail(loginDto.getEmail());

            var jwt = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setToken(jwt);
            authenticationResponse.setRefreshToken(refreshToken);
            return authenticationResponse;
        } catch (Exception ex) {
            throw new RuntimeException("Invalid Email and password");
        }
    }

    @Override
    public AuthenticationResponse refreshToken(RefresshTokenResponse refresshTokenResponse) {
        try{
            String userEmail = jwtService.extractUserName(refresshTokenResponse.getToken());
            User user = (User) userRepository.findByEmail(userEmail);
            if(jwtService.isTokenValid(refresshTokenResponse.getToken(),user)){
                var jwt = jwtService.generateToken(user);

                AuthenticationResponse authenticationResponse= new AuthenticationResponse();
                authenticationResponse.setToken(jwt);
                authenticationResponse.setRefreshToken(refresshTokenResponse.getToken());
                return authenticationResponse;
            }

        }catch (Exception ex){

            System.out.println(ex);
            return null;
        }

        return null;
    }


}
