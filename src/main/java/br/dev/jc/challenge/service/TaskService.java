package br.dev.jc.challenge.service;

import br.dev.jc.challenge.model.Task;
import br.dev.jc.challenge.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(int id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(int id) {
        Optional<Task> task = taskRepository.findById(id);

        task.ifPresent(taskRepository::delete);

    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

}
