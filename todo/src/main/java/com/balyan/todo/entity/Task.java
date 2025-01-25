package com.balyan.todo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Document(collection = "tasks")
public class Task {
    @Id
    private ObjectId id;
    private String name ;
    private String description;
    private Date duedate;
    private String Status;
}
