package com.crud.payload;


import com.crud.enums.Role;
import lombok.Data;

@Data
public class SignUpDto {

    private String firstname;

    private String lastname;

    private String password;

    private String email;

    private Role role;
}
