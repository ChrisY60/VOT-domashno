package com.example.LeagueOfLegendsEsports.service.impl;

import com.example.LeagueOfLegendsEsports.controller.resources.GameResource;
import com.example.LeagueOfLegendsEsports.entity.Game;
import com.example.LeagueOfLegendsEsports.mapper.GameMapper;
import com.example.LeagueOfLegendsEsports.repository.GameRepo;
import com.example.LeagueOfLegendsEsports.service.GameService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.LeagueOfLegendsEsports.mapper.GameMapper.MAPPER;

@Service
public class GameServiceImpl implements GameService {
    private GameRepo gameRepository;

    public GameServiceImpl(GameRepo gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameResource> findAll() {
        return MAPPER.toGameResources(gameRepository.findAll());
    }

    @Override
    public GameResource save(GameResource gameResource) {
        Game gameToSave = GameMapper.MAPPER.fromGameResource(gameResource);
        Game savedGame = gameRepository.save(gameToSave);
        return GameMapper.MAPPER.toGameResource(savedGame);
    }

    @Override
    public GameResource findById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()) {
            return MAPPER.toGameResource(game.get());
        } else {
            throw new EntityNotFoundException("No game with id: " + id);
        }
    }

    @Override
    public Game update(Long id, GameResource gameResource) {
        Optional<Game> existingGame = gameRepository.findById(id);
        if (existingGame.isPresent()) {
            Game gameToUpdate = existingGame.get();
            gameToUpdate.setDate(gameResource.getDate());
            return gameRepository.save(gameToUpdate);
        } else {
            throw new EntityNotFoundException("No game with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (gameRepository.existsById(id)) {
            gameRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No game with id: " + id);
        }
    }
}
