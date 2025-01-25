package com.balyan.todo.Services;

import com.balyan.todo.Repo.TasksRepo;
import com.balyan.todo.entity.Task;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskService {
    @Autowired
    TasksRepo taskrepo;
    public void savetask(Task naya){
        taskrepo.save(naya);
    }
    public List<Task> getall(){
        return taskrepo.findAll();
    }
    public Optional<Task> getbyid(ObjectId mid){
        return taskrepo.findById(mid);
    }
}
