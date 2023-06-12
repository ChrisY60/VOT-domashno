package com.example.LeagueOfLegendsEsports.mapper;

import com.example.LeagueOfLegendsEsports.controller.resources.StadiumResource;
import com.example.LeagueOfLegendsEsports.entity.Stadium;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = GameMapper.class)
public interface StadiumMapper {
    StadiumMapper MAPPER = Mappers.getMapper(StadiumMapper.class);
    Stadium fromStadiumResource(StadiumResource stadiumResource);
    StadiumResource toStadiumResource(Stadium stadium);
    List<StadiumResource> toStadiumResources(List<Stadium> stadiums);
}
