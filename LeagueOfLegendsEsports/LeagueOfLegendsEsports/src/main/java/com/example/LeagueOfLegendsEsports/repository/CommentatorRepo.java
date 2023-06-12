package com.example.LeagueOfLegendsEsports.repository;

import com.example.LeagueOfLegendsEsports.entity.Commentator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentatorRepo extends JpaRepository<Commentator, Long> {

}
