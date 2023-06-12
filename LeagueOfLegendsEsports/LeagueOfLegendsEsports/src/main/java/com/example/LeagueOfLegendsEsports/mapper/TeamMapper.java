package com.example.LeagueOfLegendsEsports.mapper;

import com.example.LeagueOfLegendsEsports.controller.resources.TeamResource;
import com.example.LeagueOfLegendsEsports.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {PlayerMapper.class, GameMapper.class})
public interface TeamMapper {
    TeamMapper MAPPER = Mappers.getMapper(TeamMapper.class);

    Team fromTeamResource(TeamResource teamResource);

    TeamResource toTeamResource(Team team);

    List<TeamResource> toTeamResources(List<Team> teams);


}
