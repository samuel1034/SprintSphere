package org.dasher.speed.project.service;


import org.dasher.speed.project.model.Project;
import org.dasher.speed.project.model.enums.ProjectPhase;
import org.dasher.speed.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService (ProjectRepository projectRepository) {

        this.projectRepository = projectRepository;
    }

    public List<Project> findAll () {
        return projectRepository.findAll();
    }

    public Optional <Project> findById (Long id){
        return projectRepository.findById(id);
    }

    public Project save (Project project) {
        return projectRepository.save(project);
    }

    public void Delete (Project project) {
        projectRepository.delete(project);
    }

    public Map <ProjectPhase, Long> countProjectsByPhase(){
        return projectRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Project::getPhase,
                        Collectors.counting()
                ));
    }

    public List <Project> findByPhase (ProjectPhase phase) {
        return projectRepository.findByPhase(phase);
    }



}
