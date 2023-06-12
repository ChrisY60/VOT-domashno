package com.example.LeagueOfLegendsEsports.service.impl;

import com.example.LeagueOfLegendsEsports.controller.resources.CommentatorResource;
import com.example.LeagueOfLegendsEsports.entity.Commentator;
import com.example.LeagueOfLegendsEsports.entity.Player;
import com.example.LeagueOfLegendsEsports.mapper.CommentatorMapper;
import com.example.LeagueOfLegendsEsports.mapper.PlayerMapper;
import com.example.LeagueOfLegendsEsports.repository.CommentatorRepo;
import com.example.LeagueOfLegendsEsports.repository.GameRepo;
import com.example.LeagueOfLegendsEsports.service.CommentatorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.LeagueOfLegendsEsports.mapper.CommentatorMapper.MAPPER;

@Service
public class CommentatorServiceImpl implements CommentatorService {
    private CommentatorRepo commentatorRepository;

    @Override
    public List<CommentatorResource> findAll() {
        return MAPPER.toCommentatorResources(commentatorRepository.findAll());
    }

    @Override
    public CommentatorResource save(CommentatorResource commentatorResource) {
        Commentator commentatorToSave = CommentatorMapper.MAPPER.fromCommentatorResource(commentatorResource);
        Commentator savedCommentator = commentatorRepository.save(commentatorToSave);
        return CommentatorMapper.MAPPER.toCommentatorResource(savedCommentator);
    }


    @Override
    public CommentatorResource findById(Long id) {
        Optional<Commentator> commentator = commentatorRepository.findById(id);
        if (commentator.isPresent()) {
            return MAPPER.toCommentatorResource(commentator.get());
        } else {
            throw new EntityNotFoundException("No commentator with id: " + id);
        }
    }

    @Override
    public Commentator update(Long id, CommentatorResource commentatorResource) {
        Optional<Commentator> existingCommentator = commentatorRepository.findById(id);
        if (existingCommentator.isPresent()) {
            Commentator commentatorToUpdate = existingCommentator.get();
            commentatorToUpdate.setName(commentatorResource.getName());
            commentatorToUpdate.setLanguages(commentatorResource.getLanguages());
            return commentatorRepository.save(commentatorToUpdate);
        } else {
            throw new EntityNotFoundException("No commentator with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (commentatorRepository.existsById(id)) {
            commentatorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No commentator with id: " + id);
        }
    }
}
