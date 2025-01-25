package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entities.User;
import net.engineeringdigest.journalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @GetMapping("/all-users")
    public ResponseEntity<?> getallusers() {
        try {
            return new ResponseEntity<>(userService.findalluser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add-newadmin")
    public ResponseEntity<?> createadmin(@RequestBody User nuser){
        userService.savenewadmin(nuser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
