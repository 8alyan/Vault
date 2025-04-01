package com.balyan.UserManagement.Repo;

import com.balyan.UserManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
     User findByEmail(String email);
     User findByUsername(String username);
}

