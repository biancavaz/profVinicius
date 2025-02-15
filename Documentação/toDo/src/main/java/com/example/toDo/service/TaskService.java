package com.example.toDo.service;

import com.example.toDo.models.TaskModel;
import com.example.toDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired // injeta a dependencia automaticamente(injeta no construtor da task service)
    private TaskRepository repository;

    public List<TaskModel> getAllTasks() {
        return repository.findAll(); // pegando todos os dados da extencao no repository
    }

    public TaskModel getTaskById(Integer id) {
        return repository.findById(id).get();
    }

    public List<TaskModel> getTasksByTitile() {
        return repository.findAll();
    }

    public TaskModel createTask(TaskModel task) {
        return repository.save(task);
    }

    public TaskModel updateTask(TaskModel task) {
        return repository.save(task);
    }

    public void deleteTask(int id) {
        repository.deleteById(id);
    }
}


