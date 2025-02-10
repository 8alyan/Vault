package com.balyan.UserManagement.UserController;

import com.balyan.UserManagement.UserService.UserService;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
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
    @GetMapping
    public ResponseEntity<?> allusers(){
        return new ResponseEntity<>(userService.allusers(), HttpStatus.OK);
    }
}

