package org.dasher.speed.tasks.repository;

import org.dasher.speed.project.model.Project;
import org.dasher.speed.project.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
   List<Task> findByProject (Project project);
   List <Task> findByStatus (String status);

}

