package com.zrich.scribe.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.zrich.scribe.enums.Priority;
import com.zrich.scribe.models.Todo;
import com.zrich.scribe.models.User;
import com.zrich.scribe.repositories.TodoRepository;
import com.zrich.scribe.repositories.UserRepository;
import com.zrich.scribe.services.TodoService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    UserRepository userRepo;

    TodoRepository todoRepo;

    public TodoServiceImpl(TodoRepository todoRepo, UserRepository userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    @Override
    public List<Todo> getTodosByPriority(Priority priority) {
        return todoRepo.findAllByPriority(priority);
    }

    @Override
    public List<Todo> getTodosByDate(LocalDate date) {
        return todoRepo.findAllByCreatedAt(date);
    }

    @Override
    public List<Todo> getTodosByUser(User user) {

        log.info("getting all todos for userid {}", user.getId());

        return todoRepo.findAllByUserId(Integer.valueOf(user.getId()));
    }

    @Override
    public Optional<Todo> findById(int id) {
        return todoRepo.findById(id);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepo.save(todo);
    }

    @Override
    public void deleteById(int id) {
        todoRepo.deleteById(id);
    }
    
}
