package com.crud.service;

import com.crud.entity.User;
import com.crud.payload.AuthenticationResponse;
import com.crud.payload.LoginDto;
import com.crud.payload.RefresshTokenResponse;
import com.crud.payload.SignUpDto;

public interface AuthenticationService {

    User signup(SignUpDto signUpDto);

    AuthenticationResponse login(LoginDto loginDto);

    AuthenticationResponse refreshToken (RefresshTokenResponse refresshTokenResponse );
}
