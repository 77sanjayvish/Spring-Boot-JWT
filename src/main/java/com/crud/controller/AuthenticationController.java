package com.crud.controller;

import com.crud.entity.User;
import com.crud.payload.AuthenticationResponse;
import com.crud.payload.LoginDto;
import com.crud.payload.RefresshTokenResponse;
import com.crud.payload.SignUpDto;
import com.crud.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody SignUpDto signUpDto)
    {
        return  ResponseEntity.ok(authenticationService.signup(signUpDto));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody LoginDto loginDto){

        return ResponseEntity.ok(authenticationService.login(loginDto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody RefresshTokenResponse refresshTokenResponse){

        return ResponseEntity.ok(authenticationService.refreshToken(refresshTokenResponse));
    }
}
