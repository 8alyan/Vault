package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entities.User;
import net.engineeringdigest.journalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class publicController {
    @Autowired
    UserService userService;

    @PostMapping("/create-user")
    public void saveUser(@RequestBody User nuser){
        userService.savenewuser(nuser);
    }
    @GetMapping("/health-check")
    public String healthcheck(){
        return "ok";
    }
}
