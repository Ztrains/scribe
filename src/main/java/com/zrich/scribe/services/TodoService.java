package com.zrich.scribe.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.zrich.scribe.enums.Priority;
import com.zrich.scribe.models.Todo;

public interface TodoService {

    List<Todo> getAllTodos();
    List<Todo> getTodosByPriority(Priority priority);
    List<Todo> getTodosByDate(LocalDate date);

    Optional<Todo> findById(int id);

    Todo save(Todo todo);

    void deleteById(int id);

}
