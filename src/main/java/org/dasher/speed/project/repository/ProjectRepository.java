package org.dasher.speed.project.repository;


import org.dasher.speed.project.model.Project;
import org.dasher.speed.project.model.enums.ProjectPhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByPhase(ProjectPhase phase);
}
