package com.example.LeagueOfLegendsEsports.service.impl;

import com.example.LeagueOfLegendsEsports.controller.resources.StadiumResource;
import com.example.LeagueOfLegendsEsports.entity.Stadium;
import com.example.LeagueOfLegendsEsports.mapper.StadiumMapper;
import com.example.LeagueOfLegendsEsports.repository.StadiumRepo;
import com.example.LeagueOfLegendsEsports.service.StadiumService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.LeagueOfLegendsEsports.mapper.StadiumMapper.MAPPER;

@Service
public class StadiumServiceImpl implements StadiumService {
    private StadiumRepo stadiumRepository;

    public StadiumServiceImpl(StadiumRepo stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public List<StadiumResource> findAll() {
        return MAPPER.toStadiumResources(stadiumRepository.findAll());
    }

    @Override
    public StadiumResource save(StadiumResource stadiumResource) {
        Stadium stadiumToSave = StadiumMapper.MAPPER.fromStadiumResource(stadiumResource);
        Stadium savedStadium = stadiumRepository.save(stadiumToSave);
        return StadiumMapper.MAPPER.toStadiumResource(savedStadium);
    }

    @Override
    public StadiumResource findById(Long id) {
        Optional<Stadium> stadium = stadiumRepository.findById(id);
        if (stadium.isPresent()) {
            return MAPPER.toStadiumResource(stadium.get());
        } else {
            throw new EntityNotFoundException("No stadium with id: " + id);
        }
    }

    @Override
    public Stadium update(Long id, StadiumResource stadiumResource) {
        Optional<Stadium> existingStadium = stadiumRepository.findById(id);
        if (existingStadium.isPresent()) {
            Stadium stadiumToUpdate = existingStadium.get();
            stadiumToUpdate.setName(stadiumResource.getName());
            stadiumToUpdate.setLocation(stadiumResource.getLocation());
            stadiumToUpdate.setCapacity(stadiumResource.getCapacity());
            return stadiumRepository.save(stadiumToUpdate);
        } else {
            throw new EntityNotFoundException("No stadium with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (stadiumRepository.existsById(id)) {
            stadiumRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No stadium with id: " + id);
        }
    }
}
