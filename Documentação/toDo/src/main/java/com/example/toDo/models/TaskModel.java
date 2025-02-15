package com.example.toDo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // diz que é uma entidade no banco de dados
public class TaskModel {

    @Id //primary key (identificador) --> coloca de referência no repository
    @GeneratedValue (strategy = GenerationType.IDENTITY) // pra dizer que é auto Increment
    private int id;
    private String title;
    private String description;
    private String priority;
    private String status;

    public TaskModel(int id, String status, String description, String title, String priority) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.title = title;
        this.priority = priority;
    }

    public TaskModel() {} // sempre precisa ter o construtor sem argumentos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
