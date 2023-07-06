package com.spring.Crudproject.Controller;

import com.spring.Crudproject.Model.Role;
import com.spring.Crudproject.Service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/a1")
public class RoleConstractor {

    private final RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getRoles(){
        return roleService.ShowRoles();
    }
}
