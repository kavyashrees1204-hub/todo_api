package com.example.todo_api.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo_api.model.TodoModel;
import com.example.todo_api.repo.TodoRepository;
import java.util.List;
@Service 
public class TodoServiceimpl implements TodoService{

    private TodoRepository todoRepo;

    public TodoServiceimpl(TodoRepository todoRepo){
        this.todoRepo = todoRepo;
    }

    @Override 
    public TodoModel createTodo(TodoModel task){
        return todoRepo.save(task);
    }

    public List<TodoModel> getAllTodo(){
        return todoRepo.findAll();
    }

    @Override
    public TodoModel updateTodo(Long id, TodoModel task) {
        TodoModel existingTodo = todoRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Todo not found with id: " + id));
        existingTodo.setTask(task.getTask());
        return todoRepo.save(existingTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        if (!todoRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Todo not found with id: " + id);
        }
        todoRepo.deleteById(id);
    }
}