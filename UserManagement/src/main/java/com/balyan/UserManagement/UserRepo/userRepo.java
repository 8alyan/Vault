package com.balyan.UserManagement.UserRepo;
import com.balyan.UserManagement.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepo extends CrudRepository<User,Integer> {
}
