package com.spring.Crudproject.Controller;

import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.ShowUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
       return userService.ShowUser(id);
    }

    @PostMapping("/add")
    public void AddUser(@RequestBody User user){

         userService.SaveUser(user);
    }

}
