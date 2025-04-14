package org.dasher.speed.project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String firstname;
    private String lastname;

    @ManyToMany(mappedBy = "members")
    private Set <Team> teams;

    @ManyToOne
    private Set <Project> managedProjects;

}
