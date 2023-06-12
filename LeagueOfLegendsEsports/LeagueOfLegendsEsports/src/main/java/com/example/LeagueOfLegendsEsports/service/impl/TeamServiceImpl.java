package com.example.LeagueOfLegendsEsports.service.impl;


import com.example.LeagueOfLegendsEsports.controller.resources.TeamResource;
import com.example.LeagueOfLegendsEsports.entity.Team;
import com.example.LeagueOfLegendsEsports.mapper.TeamMapper;
import com.example.LeagueOfLegendsEsports.repository.TeamRepo;
import com.example.LeagueOfLegendsEsports.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepo teamRepository;

    public TeamServiceImpl(TeamRepo teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<TeamResource> findAll() {
        return TeamMapper.MAPPER.toTeamResources(teamRepository.findAll());
    }

    @Override
    public TeamResource save(TeamResource teamResource) {
        Team teamToSave = TeamMapper.MAPPER.fromTeamResource(teamResource);
        Team savedTeam = teamRepository.save(teamToSave);
        return TeamMapper.MAPPER.toTeamResource(savedTeam);
    }

    @Override
    public TeamResource findById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            return TeamMapper.MAPPER.toTeamResource(team.get());
        } else {
            throw new EntityNotFoundException("No team with id: " + id);
        }
    }

    @Override
    public Team update(Long id, TeamResource teamResource) {
        Optional<Team> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            Team teamToUpdate = existingTeam.get();
            teamToUpdate.setName(teamResource.getName());
            return teamRepository.save(teamToUpdate);
        } else {
            throw new EntityNotFoundException("No team with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No team with id: " + id);
        }
    }
}