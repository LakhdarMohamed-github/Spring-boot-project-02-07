package com.spring.Crudproject.Repository;

import com.spring.Crudproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
