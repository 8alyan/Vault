package com.balyan.UserManagement.Controller;

import com.balyan.UserManagement.Service.UserService;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
   @GetMapping("/{id}")
    public ResponseEntity<?> getuserdetails(@PathVariable int id){
       User mham=userService.getbyid(id);
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
       if(username.equals(mham.getEmail())){
           return new ResponseEntity<>(mham,HttpStatus.FOUND);
       }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

   }
   @PutMapping("/{id}")
   public ResponseEntity<?> updateuser(@PathVariable int id,@RequestBody User naya){
       User mham=userService.getbyid(id);
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
       if(username.equals(mham.getEmail())){
           userService.updateuser(mham,naya);
           return new ResponseEntity<>(naya,HttpStatus.CREATED);
       }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

   }
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteuser(@PathVariable int id){
       User mham=userService.getbyid(id);
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
       if(username.equals(mham.getEmail())){
          userService.deleteuser(id);
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

   }
}
