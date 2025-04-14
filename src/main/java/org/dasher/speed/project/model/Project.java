package org.dasher.speed.project.model;


import jakarta.persistence.*;
import org.dasher.speed.project.model.enums.ProjectPhase;


import java.time.LocalDate;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @Enumerated (EnumType.STRING)
    private ProjectPhase phase;

    private LocalDate startDate;
    private LocalDate deadline;

    @ManyToMany
    private Set<Team> assignedTeams;

    @OneToMany
    private Set<Task> tasks;


}
