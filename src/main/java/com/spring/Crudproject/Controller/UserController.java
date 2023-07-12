package com.spring.Crudproject.Controller;

import com.spring.Crudproject.Model.Response;
import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Repository.UserRepository;
import com.spring.Crudproject.Service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;
    private final UserRepository userrep;

    @GetMapping("/")
    public ResponseEntity<Object> getUsers(){
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

    @PostMapping("/add")
    public ResponseEntity<User> AddUser(@Valid @RequestBody User user){
         return new ResponseEntity<User>(userrep.save(user),HttpStatus.OK);
        // try{
        //     return new ResponseEntity<User>(userrep.save(user),HttpStatus.OK);
        // }catch(DataIntegrityViolationException ex){
        //     System.out.println(ex.getMessage());
        //     return null;
        // }
        // try{
        //     // @RequestBody Map<String, Object> requestBody
        //     userService.SaveUser(user);

        //     return new Response<String>("user added success");
        // }
        // catch(MethodArgumentNotValidException ex){
        //     System.out.println("out !!!!");
        //     return new Response<String>(ex.getFieldErrors().get(0).getDefaultMessage());
        // }
        // catch(Exception ex){
        //     System.out.println("in !!!!");
        //     return new Response<String>(ex.getMessage());
        // }
        
        // return new ResponseEntity<User>(userrep.save(user), HttpStatus.BAD_REQUEST);

        
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> EditUser(@Valid @RequestBody User user,@PathVariable Integer id){
        userService.EditUser(user,id);
        return new ResponseEntity<Object>("user updated success !!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> DeleteUser(@PathVariable Integer id){
        userService.DeleteUser(id);
        return new ResponseEntity<Object>("user deleted success !!", HttpStatus.OK);
    }

}
