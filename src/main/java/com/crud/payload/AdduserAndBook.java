package com.crud.payload;

import com.crud.enums.Role;
import lombok.Data;

@Data
public class AdduserAndBook {

    private String userName;
    private String lastname;
    private String password;
    private String email;
    private Role role;
    private String bookName;
    private String authorName;
    private String title;
    private int price;



}
