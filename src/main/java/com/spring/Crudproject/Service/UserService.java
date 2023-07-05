package com.spring.Crudproject.Service;

import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> ShowUsers(){
        return userRepository.findAll();
    }

    public Optional<User> ShowUser(User user){
        return userRepository.findById(user.getId());
    }

}
