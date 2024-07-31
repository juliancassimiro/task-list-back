package br.dev.jc.challenge.controller;

import br.dev.jc.challenge.model.Task;
import br.dev.jc.challenge.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable int id) {
        return taskService.getTask(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        System.out.println("Método invicado");
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task newTask) {
        Optional<Task> oldTask = taskService.getTask(id);
        if(oldTask.isPresent()) {
            Task task = oldTask.get();
            task.setDescription(newTask.getDescription());
            task.setPriority(newTask.getPriority());
            task.setStatus(newTask.getStatus());
            task.setTitle(newTask.getTitle());

            return taskService.updateTask(task);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return  ResponseEntity.ok("Task deleted");
    }




}
