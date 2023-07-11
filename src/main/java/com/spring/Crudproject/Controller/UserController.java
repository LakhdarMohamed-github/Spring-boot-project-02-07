package com.spring.Crudproject.Controller;

import com.spring.Crudproject.Model.Response;
import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    @GetMapping("/")
    public Response getUsers(){
        return userService.ShowUsers();
    }

    @GetMapping("/{id}")
    public Response getUser(@PathVariable Integer id){
       try{
            return new Response<User>(userService.ShowUser(id));
       }catch(Exception e){
            return new Response<String>(e.getMessage());
       }
    }

    private boolean checkFields(User user){
        return user.getEmail()!=null && user.getPassword()!=null && user.getRole()!=null && user.getUserName()!=null;
    }

    @PostMapping("/add")
    public Response AddUser(@RequestBody Map<String, Object> requestBody){
        try{
            userService.SaveUser(requestBody);
            return new Response<String>("user added success");
        }catch(Exception ex){
            return new Response<String>(ex.getMessage());
        }
    }

    @PutMapping("/edit/{id}")
    public void EditUser(@RequestBody User user,@PathVariable Integer id){
        userService.EditUser(user,id);
    }

    @DeleteMapping("/delete/{id}")
    public void EditUser(@PathVariable Integer id){
        userService.DeleteUser(id);
    }

}
