package org.dasher.speed.tasks.service;

import org.dasher.speed.project.model.Project;
import org.dasher.speed.project.model.enums.TaskStatus;
import org.dasher.speed.tasks.domain.Task;
import org.dasher.speed.tasks.domain.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll () {
        return taskRepository.findAll();
    }

    public List <Task> findByProject (Project project) {
        return taskRepository.findByProject(project);
    }

    public List <Task>  findByStatus (String status) {
        return taskRepository.findByStatus(status);
    }

    public Task save (Task task) {
        return taskRepository.save(task);
    }

    public void delete (Task task) {
        taskRepository.delete(task);
    }
    public Map <TaskStatus, Long> countTasksByStatus () {
        return taskRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Task::getStatus,
                        Collectors.counting()
                ));
    }
}
