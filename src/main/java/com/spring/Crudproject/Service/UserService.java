package com.spring.Crudproject.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.Crudproject.Model.Response;
import com.spring.Crudproject.Model.Role;
import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Repository.RoleRepository;
import com.spring.Crudproject.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Response ShowUsers(){
        List<User> x=userRepository.findAll();

        return x.isEmpty()? new Response<String>("no user exist !!"):new Response<List<User>>(x);
    }

    public User ShowUser(Integer id){
        return userRepository.findById(id).orElseThrow(()-> {
            try {
                throw new Exception("No user found!");
            } catch (Exception e) {
                throw new RuntimeException("No user found!");
            }
        });
    }

    public void SaveUser(Map<String, Object> requestBody) throws Exception{

        List<String> fl=new ArrayList<String>();
        Field[] f = User.class.getDeclaredFields();
        for(Field x : f){
            if(x.getName()!="id")
                fl.add(x.getName());
        }



        for(String x : fl){
            if(!requestBody.keySet().contains(x)){
                throw new Exception(x+" not found !!");
            }
        }

        for(String x : requestBody.keySet()){
            if(!fl.contains(x)){
                throw new Exception(x+" not wanted field !!");
            }
        }

        User user=new ObjectMapper().convertValue(requestBody, User.class);

        Optional<User> x=userRepository.findByEmailOrUserName(user.getEmail(),user.getUserName());


        if(x.isPresent()){
            throw new Exception("user already exist !");
        }

        Optional<Role> r= roleRepository.findById(user.getRole().getRole_id());
        if(!r.isPresent()){
            throw new Exception("role id not exist !!");
        }

        
        userRepository.save(user);


        
    }

    public void UpdateUser(@RequestBody User user){

    }

    public void EditUser(User user,Integer id){
        User x = userRepository.findById(id).get();
        x.setEmail(user.getEmail());
        x.setPassword(user.getPassword());
        x.setUserName(user.getUserName());
        x.setRole(user.getRole());

        userRepository.save(x);
        
    }

    public void DeleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
