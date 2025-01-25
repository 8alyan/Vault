package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entities.User;
import net.engineeringdigest.journalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PutMapping()
    public ResponseEntity<?> updateuser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userdb = userService.findbyusername(username);
        if(userdb!=null){
            userdb.setUsername(user.getUsername());
            userdb.setPassword(user.getPassword());
            userService.savenewuser(userdb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteuser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userService.deletebyusername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
