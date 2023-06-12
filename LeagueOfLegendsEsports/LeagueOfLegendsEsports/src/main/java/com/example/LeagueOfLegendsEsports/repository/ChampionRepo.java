package com.example.LeagueOfLegendsEsports.repository;

import com.example.LeagueOfLegendsEsports.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepo extends JpaRepository<Champion, Long> {
}
