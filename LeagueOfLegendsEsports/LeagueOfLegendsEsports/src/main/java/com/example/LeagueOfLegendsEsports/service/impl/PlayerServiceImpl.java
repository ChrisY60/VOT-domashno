package com.example.LeagueOfLegendsEsports.service.impl;

import com.example.LeagueOfLegendsEsports.controller.resources.PlayerResource;
import com.example.LeagueOfLegendsEsports.entity.Player;
import com.example.LeagueOfLegendsEsports.repository.PlayerRepo;
import com.example.LeagueOfLegendsEsports.service.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.LeagueOfLegendsEsports.mapper.PlayerMapper.MAPPER;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepo playerRepository;

    @Override
    public List<PlayerResource> findAll() {
        return MAPPER.toPlayerResources(playerRepository.findAll());
    }

    @Override
    public PlayerResource save(PlayerResource playerResource) {
        Player playerToSave = MAPPER.fromPlayerResource(playerResource);
        Player savedPlayer = playerRepository.save(playerToSave);
        return MAPPER.toPlayerResource(savedPlayer);
    }

    @Override
    public PlayerResource findById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            return MAPPER.toPlayerResource(player.get());
        } else {
            throw new EntityNotFoundException("No player with id: " + id);
        }
    }

    @Override
    public Player update(Long id, PlayerResource playerResource) {
        Optional<Player> existingPlayer = playerRepository.findById(id);
        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(playerResource.getName());
            playerToUpdate.setNickname(playerResource.getNickname());
            playerToUpdate.setRole(playerResource.getRole());
            return playerRepository.save(playerToUpdate);
        } else {
            throw new EntityNotFoundException("No player with id: " + id);
        }

    }

    @Override
    public void delete(Long id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No player with id: " + id);
        }

    }
}
