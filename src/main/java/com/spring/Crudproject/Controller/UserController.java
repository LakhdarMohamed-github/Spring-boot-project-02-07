package com.spring.Crudproject.Controller;

import com.spring.Crudproject.Model.Response;
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
    /*public List<User> getUsers(){
        //if(!userService.ShowUsers().isEmpty()){
            return userService.ShowUsers();
        //}else
         //   return null;
    }*/
    public Response getUsers(){

        return userService.ShowUsers();
    }

    @GetMapping("/{id}")
    public Response getUser(@PathVariable Integer id){
      // return userService.ShowUser(id);
        try{
            return new Response<User>(userService.ShowUser(id));
        }catch(Exception e){
            return new Response<String>(e.getMessage());
        }
    }

    @PostMapping("/add")
    public void AddUser(@RequestBody User user){

         userService.SaveUser(user);
    }

    @PutMapping("/edit/{id}")
    public void UpdateUser(@PathVariable Integer id, @RequestBody User user){
         userService.UpdateUser(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteUser(@PathVariable Integer id){
        userService.Delete(id);
    }
}
