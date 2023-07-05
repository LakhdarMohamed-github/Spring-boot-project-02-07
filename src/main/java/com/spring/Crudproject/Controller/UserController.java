package com.spring.Crudproject.Controller;

import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.ShowUsers();
    }

}
