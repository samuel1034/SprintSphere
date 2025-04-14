package org.dasher.speed.project.model;

import jakarta.persistence.*;
import org.dasher.speed.project.model.enums.Priority;
import org.dasher.speed.project.model.enums.TaskStatus;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDate dueDate;

    @ManyToOne
    private User assignee;

    @ManyToMany
    private Project project;
}
