package org.dasher.speed.project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    @ManyToMany
    @JoinTable(
            name = "team_members",
            JoinColumns = @JoinColumn('team_id'),
            inverseJoinColumns = @JoinColumn('user_id')
    )
    private Set<User> members;


}
