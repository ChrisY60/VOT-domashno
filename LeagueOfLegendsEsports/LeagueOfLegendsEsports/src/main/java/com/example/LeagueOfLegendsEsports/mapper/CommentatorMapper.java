package com.example.LeagueOfLegendsEsports.mapper;

import com.example.LeagueOfLegendsEsports.controller.resources.CommentatorResource;
import com.example.LeagueOfLegendsEsports.entity.Commentator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = GameMapper.class)
public interface CommentatorMapper {
    CommentatorMapper MAPPER = Mappers.getMapper(CommentatorMapper.class);
    Commentator fromCommentatorResource(CommentatorResource commentatorResource);
    CommentatorResource toCommentatorResource(Commentator commentator);
    List<CommentatorResource> toCommentatorResources(List<Commentator> commentators);
}
