package com.example.LeagueOfLegendsEsports.mapper;

import com.example.LeagueOfLegendsEsports.controller.resources.ChampionResource;
import com.example.LeagueOfLegendsEsports.entity.Champion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = GameMapper.class)
public interface ChampionMapper {
    ChampionMapper MAPPER = Mappers.getMapper(ChampionMapper.class);
    Champion fromChampionResource(ChampionResource championResource);
    ChampionResource toChampionResource(Champion champion);
    List<ChampionResource> toChampionResources(List<Champion> champions);
}
