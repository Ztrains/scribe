package com.zrich.scribe.controllers;

import java.time.LocalDate;
import java.util.List;

import com.zrich.scribe.enums.Priority;
import com.zrich.scribe.exceptions.EntityNotFoundException;
import com.zrich.scribe.models.Todo;
import com.zrich.scribe.services.TodoService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/todos")
@SuppressWarnings("all")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // List<Todo>
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/prio/{prio}")
    public List<Todo> getTodosByPriority(@PathVariable("prio") Priority prio) {
        return todoService.getTodosByPriority(prio);
    }

    @GetMapping(params = "date")
    public List<Todo> getTodosByDate(@RequestParam("date") 
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
                                     LocalDate date) {
        return todoService.getTodosByDate(date);
    }


    // Todo
    @GetMapping("/id/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo with id " + id + " not found."));
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PostMapping("/web")
    public RedirectView addTodoBrowser(Todo todo) {
        todoService.save(todo);
        return new RedirectView("http://localhost:8080/scribe");
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo newTodo) {
        Todo todo = todoService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo with id " + id + " not found."));

        todo.setTask(newTodo.getTask());
        todo.setPriority(newTodo.getPriority());

        return todoService.save(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        Todo todo = todoService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo with id " + id + " not found."));

        todoService.deleteById(todo.getId());
        return "Todo with id " + id + " is deleted";
    }
    
}
