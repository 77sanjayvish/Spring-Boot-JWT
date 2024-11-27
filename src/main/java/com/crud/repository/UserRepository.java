package com.crud.repository;

import com.crud.entity.User;
import com.crud.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {

    UserDetails findByEmail(String email);


    User findByRole(Role role);

    User findByFirstname(String username);
}
