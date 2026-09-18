package com.example.todo_api.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;

import com.example.todo_api.model.TodoModel;
import com.example.todo_api.service.TodoService;

import java.util.List;


@RestController 
@RequestMapping("/todos") 
public class TodoController {
    private  TodoService todoSer;

    public TodoController(TodoService todoSer) {
        this.todoSer = todoSer;
    }

    @PostMapping("/createTodo")
    public TodoModel createTodo(@RequestBody TodoModel task){
        return todoSer.createTodo(task);
    }

    @GetMapping("/getTodo")
    public List<TodoModel>getAllTodo(){
        return todoSer.getAllTodo();
    }

    @PutMapping("/updateTodo/{id}")
    public TodoModel updateTodo(@PathVariable Long id, @RequestBody TodoModel task) {
        return todoSer.updateTodo(id, task);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoSer.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}

