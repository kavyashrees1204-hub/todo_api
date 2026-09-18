package com.example.todo_api.service;
import com.example.todo_api.model.TodoModel;
import java.util.List;
public interface TodoService {
 TodoModel createTodo(TodoModel task);
 List<TodoModel>getAllTodo();
 TodoModel updateTodo(Long id, TodoModel task);
 void deleteTodo(Long id);
}