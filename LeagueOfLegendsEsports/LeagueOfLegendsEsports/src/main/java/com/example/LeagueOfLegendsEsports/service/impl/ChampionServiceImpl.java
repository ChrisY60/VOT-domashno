package com.example.LeagueOfLegendsEsports.service.impl;

import com.example.LeagueOfLegendsEsports.controller.resources.ChampionResource;
import com.example.LeagueOfLegendsEsports.entity.Champion;
import com.example.LeagueOfLegendsEsports.mapper.ChampionMapper;
import com.example.LeagueOfLegendsEsports.repository.ChampionRepo;
import com.example.LeagueOfLegendsEsports.service.ChampionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.LeagueOfLegendsEsports.mapper.ChampionMapper.MAPPER;

@Service
public class ChampionServiceImpl implements ChampionService {
    private ChampionRepo championRepository;

    public ChampionServiceImpl(ChampionRepo championRepository) {
        this.championRepository = championRepository;
    }

    @Override
    public List<ChampionResource> findAll() {
        return MAPPER.toChampionResources(championRepository.findAll());
    }

    @Override
    public ChampionResource save(ChampionResource championResource) {
        Champion championToSave = ChampionMapper.MAPPER.fromChampionResource(championResource);
        Champion savedChampion = championRepository.save(championToSave);
        return ChampionMapper.MAPPER.toChampionResource(savedChampion);
    }

    @Override
    public ChampionResource findById(Long id) {
        Optional<Champion> champion = championRepository.findById(id);
        if (champion.isPresent()) {
            return MAPPER.toChampionResource(champion.get());
        } else {
            throw new EntityNotFoundException("No champion with id: " + id);
        }
    }

    @Override
    public Champion update(Long id, ChampionResource championResource) {
        Optional<Champion> existingChampion = championRepository.findById(id);
        if (existingChampion.isPresent()) {
            Champion championToUpdate = existingChampion.get();
            championToUpdate.setName(championResource.getName());
            return championRepository.save(championToUpdate);
        } else {
            throw new EntityNotFoundException("No champion with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (championRepository.existsById(id)) {
            championRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No champion with id: " + id);
        }
    }
}
