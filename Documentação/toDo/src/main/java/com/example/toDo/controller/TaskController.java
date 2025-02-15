package com.example.toDo.controller;

import com.example.toDo.models.TaskModel;
import com.example.toDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service; // injetando

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        List<TaskModel> tasks = service.getAllTasks();
        return ResponseEntity.ok().body(service.getAllTasks()); //
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Integer id) {
        TaskModel task = service.getTaskById(id);
        return ResponseEntity.ok().body(service.getTaskById(id));
    }

    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task) {
        return service.createTask(task);
    }

    @PutMapping
    public TaskModel updateTask(@RequestBody TaskModel task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        service.deleteTask(id);
    }


}
