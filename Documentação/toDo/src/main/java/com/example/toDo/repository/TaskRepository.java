package com.example.toDo.repository;

import com.example.toDo.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Integer> {

    // ele pede o TaskModel com o tipo de dado para comunicar som o banco

    TaskModel findByTitle(String title); // busca por títulos
}
