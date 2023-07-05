package com.spring.Crudproject.Service;

import com.spring.Crudproject.Model.Role;
import com.spring.Crudproject.Model.User;
import com.spring.Crudproject.Repository.RoleRepository;
import com.spring.Crudproject.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> ShowRoles(){
        return roleRepository.findAll();
    }

}
