package com.balyan.UserManagement.Service;

import com.balyan.UserManagement.Repo.UserRepo;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private  UserRepo userRepo;

    public String addUser(User user) {
        try {
            if(user.getPassword().length()<6){return "password length too small nigesh";}
            if (userRepo.findByEmail(user.getEmail())!=null){return "email already exists nigesh";}
            userRepo.save(user);
            return "user created successfully";
        } catch (Exception e) {
            return  "user not  created successfully";
        }
    }
    public List<User> allusers(){
        return (List<User>) userRepo.findAll();
    }
}

