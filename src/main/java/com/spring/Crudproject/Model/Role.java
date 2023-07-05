package com.spring.Crudproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;
    private String name;

    @OneToMany(mappedBy ="role" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users;
}
