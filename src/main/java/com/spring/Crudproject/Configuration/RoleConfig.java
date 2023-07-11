package com.spring.Crudproject.Configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.Crudproject.Model.Role;
import com.spring.Crudproject.Repository.RoleRepository;

@Configuration
public class RoleConfig {

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository ro){
        return args ->  {
            Role r=new Role(null,"admin",null);
            Role r2=new Role(null,"client",null);
            Role r3=new Role(null,"manager",null);

            ro.saveAll(
                    List.of(r,r2,r3)
            );
        };
    }
}
