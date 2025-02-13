package com.balyan.UserManagement.Controller;

import com.balyan.UserManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<?> allusers(){
        return new ResponseEntity<>(userService.allusers(), HttpStatus.OK);
    }
}
