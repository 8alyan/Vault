package com.balyan.UserManagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Arrays;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String roles="";

    public List<String> getRoles() {
        return Arrays.stream(roles.split(",")).toList();
    }

    public void setRoles(String role) {
        if(this.roles.isEmpty()){this.roles=role;}
        else{
        this.roles+=","+role;}
    }
}
