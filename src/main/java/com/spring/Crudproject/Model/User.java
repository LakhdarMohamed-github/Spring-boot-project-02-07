package com.spring.Crudproject.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_name"})
)

public class User {
    // DataIntegrityViolationException
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 4,max=10)
    private String userName;
    @Column(unique = true, nullable = false)
    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    @NotNull
    @NotBlank
    @NotEmpty
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties("users")
    @NotNull
    private Role role;
}
