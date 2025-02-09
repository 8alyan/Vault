package com.balyan.UserManagement.UserService;

import com.balyan.UserManagement.UserRepo.userRepo;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private userRepo us;
    public boolean adduser(User user){
        try {
        us.save(user);
        return true;}
        catch (Exception e){
            return false;
        }
    }


}
