package com.coders.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coders.demo.model.Task;
import com.coders.demo.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task create(Task task) {
        return repo.save(task);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task update(Long id, Task updatedTask) {
        return repo.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            return repo.save(task);
        }).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}