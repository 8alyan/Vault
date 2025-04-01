package com.balyan.UserManagement.Service;

import com.balyan.UserManagement.Repo.UserRepo;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private  UserRepo userRepo;
    private final static PasswordEncoder code = new BCryptPasswordEncoder();

    public String addUser(User user) {
        try {
            if(user.getPassword().length()<6){return "password length too small nigesh";}
            user.setPassword(code.encode(user.getPassword()));
            user.setRoles("USER");
            userRepo.save(user);
            return "user created successfully";
        } catch (Exception e) {
            return  "user not  created successfully";
        }
    }
    public List<User> allusers(){
        return  userRepo.findAll();
    }
    public User getbyid(int id){
        return userRepo.findById(id).orElse(null);

    }
    public User updateuser(User purana,User nyaa){
        nyaa.setId(purana.getId());
        for(String j : purana.getRoles()){
            nyaa.setRoles(j);
        }
        nyaa.setPassword(code.encode(nyaa.getPassword()));
        userRepo.save(nyaa);
        return nyaa;
    }
    public void deleteuser(int id){
        userRepo.deleteById(id);
    }
    public void saveuser(User nyaa){
        userRepo.save(nyaa);
    }
}

