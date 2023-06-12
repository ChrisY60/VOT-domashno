package com.example.LeagueOfLegendsEsports.mapper;

import com.example.LeagueOfLegendsEsports.controller.resources.PlayerResource;
import com.example.LeagueOfLegendsEsports.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface PlayerMapper {
    PlayerMapper MAPPER = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "team.name", source = "playerResource.teamName")
    Player fromPlayerResource(PlayerResource playerResource);

    @Mapping(target = "teamName", source = "player.team.name")
    PlayerResource toPlayerResource(Player player);

    List<PlayerResource> toPlayerResources(List<Player> players);
}
