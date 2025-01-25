package com.balyan.todo.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Task {
    private String name ;
    private String description;
    private Date duedate;
    private String Status;
}
