package com.balyan.UserManagement.UserService;

import com.balyan.UserManagement.UserRepo.UserRepo;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean addUser(User user) {
        try {
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            logger.error("Error saving user: {}", e.getMessage());
            return false;
        }
    }
    public List<User> allusers(){
        return (List<User>) userRepo.findAll();
    }
}

