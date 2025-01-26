package com.balyan.todo.Services;

import com.balyan.todo.Repo.TasksRepo;
import com.balyan.todo.entity.Task;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TaskService {
    @Autowired
    TasksRepo taskrepo;
    public ResponseEntity<?> savetask(Task naya){
        boolean a = naya.getDuedate().before(new Date());
        boolean b = naya.getName().isBlank()||naya.getName().isEmpty();
        boolean c = !(naya.getStatus().equalsIgnoreCase("completed")||naya.getStatus().equalsIgnoreCase("pending"));
        if(a||b||c){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        taskrepo.save(naya);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    public ResponseEntity<?> getall(){
        return new ResponseEntity<>(taskrepo.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<?> getbyid(ObjectId mid){
        Optional<Task> j = taskrepo.findById(mid);
        if(j.isPresent()){
            return new ResponseEntity<>(j.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> deletebyid(ObjectId mid){
        Optional<Task> j = taskrepo.findById(mid);
        if(j.isPresent()){
            taskrepo.deleteById(mid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> updatebyid(ObjectId mid,Task naya){
        Optional<Task> j = taskrepo.findById(mid);
        if(j.isPresent()){
            j.get().setName(naya.getName());
            j.get().setDescription(naya.getDescription());
            j.get().setDuedate(naya.getDuedate());
            j.get().setStatus(naya.getStatus());
           if(savetask(j.get()).getStatusCode().equals(HttpStatus.BAD_REQUEST)){
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
