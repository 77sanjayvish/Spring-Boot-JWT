package com.crud;

import com.crud.entity.User;
import com.crud.enums.Role;
import com.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);


	}
//
//	public void run(String [] args){
//
//		User AdminAccount = userRepository.findByRole(Role.ADMIN);
//		if(AdminAccount == null)
//		{
//			User user = new User();
//			user.setFirstname("admin");
//			user.setLastname("admin");
//			user.setRole(Role.ADMIN);
//			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
//
//			userRepository.save(user);
//		}

}
