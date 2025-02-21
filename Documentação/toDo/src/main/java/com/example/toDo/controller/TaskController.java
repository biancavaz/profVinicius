package com.example.toDo.controller;

import com.example.toDo.models.TaskModel;
import com.example.toDo.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Tag(name = "tasks", description = "Gerenciamento de tarefas")
public class TaskController {

    @Autowired
    private TaskService service; // injetando


    @GetMapping
    @ApiResponse(responseCode = "201", description = "tasks buscadas com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @Operation(summary = "lista todas as tarefas", description = "retorna uma lista de todas as tarefas já cadastradas")
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        List<TaskModel> tasks = service.getAllTasks();
        return ResponseEntity.ok().body(service.getAllTasks()); //
    }

    @Operation(summary = "lista a tarefa pelo id", description = "retorna uma tarefa buscada pelo id, já cadastrada")
    @ApiResponse(responseCode = "201", description = "task buscada pelo id com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Integer id) {
        TaskModel task = service.getTaskById(id);
        return ResponseEntity.ok().body(service.getTaskById(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201", description = "task criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @Operation(summary = "cria uma tarefa", description = "retorna que uma tarefa foi criada/cadastrada")
    public TaskModel createTask(@RequestBody
            @Parameter(description = "objeto task a ser criado",required = true,
                    content = @Content(schema = @Schema(implementation = TaskModel.class)))
                                    TaskModel task) {
        return service.createTask(task);
    }

    @PutMapping
    @ApiResponse(responseCode = "201", description = "task editada com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @Operation(summary = "atualiza uma tarefa", description = "retorna que a tarefa foi atualiza")
    public TaskModel updateTask(@RequestBody TaskModel task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "task deletada com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @Operation(summary = "deleta uma tarefa pelo id", description = "informar um id para a delecao da tarefa")
    public void deleteTask(@PathVariable Integer id) {
        service.deleteTask(id);
    }


}
