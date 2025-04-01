package com.balyan.UserManagement.Service;

import com.balyan.UserManagement.Repo.UserRepo;
import com.balyan.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepo.findByEmail(email);
        if(user!=null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();

        }
        throw new UsernameNotFoundException("User not Found with username: "+email);
    }
}
