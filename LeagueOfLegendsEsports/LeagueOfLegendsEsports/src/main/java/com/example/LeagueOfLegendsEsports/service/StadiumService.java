package com.example.LeagueOfLegendsEsports.service;

import com.example.LeagueOfLegendsEsports.controller.resources.StadiumResource;
import com.example.LeagueOfLegendsEsports.entity.Stadium;

import java.util.List;

public interface StadiumService {
    List<StadiumResource> findAll();

    StadiumResource save(StadiumResource stadium);

    StadiumResource findById(Long id);

    Stadium update(Long id, StadiumResource stadiumResource);

    void delete(Long id);
}
