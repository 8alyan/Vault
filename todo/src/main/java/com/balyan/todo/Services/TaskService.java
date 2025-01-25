package com.balyan.todo.Services;

import com.balyan.todo.Repo.TasksRepo;
import com.balyan.todo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {
    @Autowired
    TasksRepo taskrepo;
    public void savetask(Task naya){
        taskrepo.save(naya);
    }
}
