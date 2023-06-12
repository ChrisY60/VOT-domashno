package com.example.LeagueOfLegendsEsports.repository;

import com.example.LeagueOfLegendsEsports.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository <Player, Long>{

}
