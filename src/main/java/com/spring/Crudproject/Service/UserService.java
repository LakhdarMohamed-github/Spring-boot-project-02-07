package com.spring.Crudproject.Service;

import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> ShowUsers(){
        return userRepository.findAll();
    }

    public User ShowUser(Integer id){
        return userRepository.findById(id).orElseThrow();
    }

    public void SaveUser(User user){
       /* if(!userRepository.findByEmail(user.getEmail())){
            return userRepository.save(user);
        }else {
            System.out.println("The email exist!");
            return null;
        }*/
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if(optionalUser.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        userRepository.save(user);
    }

    public void UpdateUser(@RequestBody User user){

    }

}
