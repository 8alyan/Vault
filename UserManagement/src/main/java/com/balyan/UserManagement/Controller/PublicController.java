package com.balyan.UserManagement.Controller;

import com.balyan.UserManagement.Service.UserService;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private  UserService userService;

    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody User user) {
        String isAdded = userService.addUser(user);
        if (isAdded.equals("user created successfully")) {
            return ResponseEntity.status(201).body("User created successfully");
        }
        return ResponseEntity.status(400).body(isAdded);
    }

}

