package com.balyan.UserManagement.Controller;

import com.balyan.UserManagement.Service.UserService;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<?> allusers(){
        return new ResponseEntity<>(userService.allusers(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteuser(@PathVariable int id){
        userService.deleteuser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}/{role}")
    public ResponseEntity<?> roleadd(@PathVariable int id,@PathVariable String role){
        User aya = userService.getbyid(id);
        if(aya!=null){
            aya.setRoles(role);
            userService.saveuser(aya);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getuserdetails(@PathVariable int id){
        User mham=userService.getbyid(id);
        if(mham!=null){
            return new ResponseEntity<>(mham,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateuser(@PathVariable int id,@RequestBody User naya){
        User mham=userService.getbyid(id);
        if(mham!=null){
            userService.updateuser(mham,naya);
            return new ResponseEntity<>(naya,HttpStatus.CREATED);}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
