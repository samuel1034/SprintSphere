package org.dasher.speed.teams.service;

import org.dasher.speed.project.model.Team;
import org.dasher.speed.teams.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService (TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List <Team> findAll () {
        return teamRepository.findAll();
    }

    public Team save (Team team) {
        return teamRepository.save(team);
    }

    public Optional<Team> findById (Long id) {
        return teamRepository.findById(id);
    }

    public void delete (Team team) {
        teamRepository.delete(team);
    }
}
