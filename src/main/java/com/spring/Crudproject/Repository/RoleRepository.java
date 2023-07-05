package com.spring.Crudproject.Repository;

import com.spring.Crudproject.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
