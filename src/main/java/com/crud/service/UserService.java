package com.crud.service;


import com.crud.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDetailsService userDetailsService();
//    Add User
    User createUser(User user);
//    update User
    Optional<User> updateUser(User user);
//    delete User
    void deleteUser(int id);
//    get One User
    String getSingleUser(int id);
////    getAll Users
    List<User> getAllUsers();


    Optional<User> getUserByID(int id);
}
