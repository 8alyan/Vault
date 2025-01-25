package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entities.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.autoconfigure.security.SecurityProperties;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepo.findByusername(username);
        if(user!=null){
            return org.springframework.security.core.userdetails.User.builder()
                     .username(user.getUsername())
                     .password(user.getPassword())
                     .roles(user.getRoles().toArray(new String[0])).build();
        }
        throw new UsernameNotFoundException("User not Found with username: "+username);
    }
}
