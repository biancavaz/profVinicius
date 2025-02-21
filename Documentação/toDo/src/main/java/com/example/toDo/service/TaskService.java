package com.example.toDo.service;

import com.example.toDo.models.TaskModel;
import com.example.toDo.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired // injeta a dependencia automaticamente(injeta no construtor da task service)
    private TaskRepository repository;

    /**
     * metodo que busca todas as tarefas
     *
     * @return "retorna todas as tarefas"
     */
    public List<TaskModel> getAllTasks() {
        return repository.findAll(); // pegando todos os dados da extencao no repository
    }


    /**
     * @param id "envia o id da tarefa que deseja procurar"
     * @return "retorna uma tarefa específica buscadd pelo id"
     */
    public TaskModel getTaskById(Integer id) {
        return repository.findById(id).get();
    }

    /**
     * metodo que busca todas as tarefas pelo título
     *
     * @return "retorna as tarefas buscadas pelo titúlo"
     */
    public List<TaskModel> getTasksByTitile() {
        return repository.findAll();
    }

    /**
     *
     * @param task "cria as tasks novas"
     * @return "retorna que as tarefas foram criadas"
     */
    public TaskModel createTask(TaskModel task) {
        return repository.save(task);
    }

    /**
     *
     * @param task "atualiza tarefas já existentes"
     * @return "retorna que as tasks foram salvas"
     */
    public TaskModel updateTask(TaskModel task) {
        return repository.save(task);
    }

    /**
     * metodo que apaga uma task
     *
     * @param id "eviar o id para a task ser deletada "
     */
    public void deleteTask(int id) {
        repository.deleteById(id);
    }
}


