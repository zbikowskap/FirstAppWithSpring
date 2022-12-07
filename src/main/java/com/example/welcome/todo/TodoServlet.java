package com.example.welcome.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
class TodoServlet{
    private final Logger logger = LoggerFactory.getLogger(Todo.class);
    private TodoRepository repository;

    //konstruktor
    TodoServlet(TodoRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    ResponseEntity<List<Todo>> findAllTodos(){
        logger.info("Got request");
        return ResponseEntity.ok(repository.findAll());
    }
    @PutMapping("/{id}")
   ResponseEntity<Todo>toggleTodo(@PathVariable Integer id){
        var todo = repository.findById(id); //jeśłi cos zwórci to dlatego optional
        todo.ifPresent(t ->{
            t.setDone(!t.isDone());
            repository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        }
        @PostMapping
        ResponseEntity<Todo> saveTodo(@RequestBody Todo toto){
        return ResponseEntity.ok(repository.save(toto));
        }

}
