package com.spring.Crudproject;

import com.spring.Crudproject.Model.Role;
import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Repository.RoleRepository;
import com.spring.Crudproject.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
	}


}
