package com.example.LeagueOfLegendsEsports.mapper;

import com.example.LeagueOfLegendsEsports.controller.resources.GameResource;
import com.example.LeagueOfLegendsEsports.entity.Game;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {TeamMapper.class, StadiumMapper.class, ChampionMapper.class, CommentatorMapper.class})
public interface GameMapper {
    GameMapper MAPPER = Mappers.getMapper(GameMapper.class);

    @Mapping(target = "blueTeam.name", source = "blueTeam")
    @Mapping(target = "redTeam.name", source = "redTeam")
    @Mapping(target = "winnerTeam.name", source = "winnerTeam")
    @Mapping(target = "stadium.name", source = "stadium")
    Game fromGameResource(GameResource gameResource);

    @Mapping(target = "blueTeam", source = "blueTeam.name")
    @Mapping(target = "redTeam", source = "redTeam.name")
    @Mapping(target = "winnerTeam", source = "winnerTeam.name")
    @Mapping(target = "stadium", source = "stadium.name")
    GameResource toGameResource(Game game);

    List<GameResource> toGameResources(List<Game> games);
}
