package com.balyan.todo.controller;

import com.balyan.todo.Repo.TasksRepo;
import com.balyan.todo.Services.TaskService;
import com.balyan.todo.entity.Task;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("tasks")
public class taskController {
    @Autowired
    TaskService taskService;
    @PostMapping()
    public ResponseEntity<?> createtask(@RequestBody Task aya){
       return taskService.savetask(aya);
    }
    @GetMapping()
    public ResponseEntity<?> getall(){
        return taskService.getall();
    }
    @GetMapping("/id/{mid}")
    public ResponseEntity<?> getbyid(@PathVariable ObjectId mid){
        return taskService.getbyid(mid);
    }
    @DeleteMapping("/id/{mid}")
    public ResponseEntity<?> deletebyid(@PathVariable ObjectId mid){
        return taskService.deletebyid(mid);
    }
    @PutMapping("/id/{mid}")
    public ResponseEntity<?> update(@RequestBody Task aya,@PathVariable ObjectId mid){
        return taskService.updatebyid(mid,aya);
    }


}
