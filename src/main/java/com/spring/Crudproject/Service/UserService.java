package com.spring.Crudproject.Service;

import com.spring.Crudproject.Model.Response;
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

    public Response ShowUsers(){
        List<User> x=userRepository.findAll();

        return x.isEmpty()? new Response<String>("No User is found!"):new Response<List<User>>(x);
    }

    public User ShowUser(Integer id){
        return userRepository.findById(id).orElseThrow(()-> {
            try {
                throw new Exception("No user found!");
            } catch (Exception e) {
                throw new RuntimeException("No user found!");
            }
        });
        //return userRepository.findById(id).orElseThrow();
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

    public void UpdateUser(User user, Integer id){

        User use = userRepository.findById(id).get();
        use.setUserName(user.getUserName());
        use.setEmail(user.getEmail());
        use.setPassword(user.getPassword());
        use.setRole(user.getRole());

        userRepository.save(use);

    }

    public void Delete(Integer id) {

        userRepository.deleteById(id);

    }
}
