package com.balyan.UserManagement.UserRepo;

import com.balyan.UserManagement.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
     User findByemail(String email);
}

