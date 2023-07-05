package com.spring.Crudproject.Service;

import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> ShowUsers(){
        return userRepository.findAll();
    }

}
