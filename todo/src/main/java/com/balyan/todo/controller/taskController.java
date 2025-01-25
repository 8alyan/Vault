package com.balyan.todo.controller;

import com.balyan.todo.Repo.TasksRepo;
import com.balyan.todo.Services.TaskService;
import com.balyan.todo.entity.Task;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("tasks")
public class taskController {
    @Autowired
    TaskService taskService;
    List<Task> s = new ArrayList<>();
    @PostMapping()
    public void createtask(@RequestBody Task aya){
       taskService.savetask(aya);
    }
    @GetMapping()
    public List<Task> getall(){
        return taskService.getall();
    }
    @GetMapping("/id/{mid}")
    public Task getbyid(@PathVariable ObjectId mid){
        return taskService.getbyid(mid).orElse(null);
    }


}
