package com.example.LeagueOfLegendsEsports.repository;

import com.example.LeagueOfLegendsEsports.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {

}
