package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entities.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class UserService {
    @Autowired
    UserRepo userRepo;
    private final static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public void savenewuser(User nuser){
        nuser.setPassword(passwordEncoder.encode(nuser.getPassword()));
        nuser.setRoles(Arrays.asList("USER"));
        userRepo.save(nuser);
    }
    public void saveuser(User ouser){
        userRepo.save(ouser);
    }
    public List<User> findalluser(){
        return userRepo.findAll();
    }
    public User findbyusername(String uid){
        return userRepo.findByusername(uid);
    }
    public void deletebyid(ObjectId uid){
        userRepo.deleteById(uid);
    }
    public void deletebyusername(String username){
        userRepo.deleteByusername(username);
    }

    public void savenewadmin(User nuser) {
        nuser.setPassword(passwordEncoder.encode(nuser.getPassword()));
        nuser.setRoles(Arrays.asList("USER","ADMIN"));
        userRepo.save(nuser);
    }
}
