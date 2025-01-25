package com.balyan.todo.Repo;

import com.balyan.todo.entity.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface TasksRepo extends MongoRepository<Task,ObjectId> {
}
