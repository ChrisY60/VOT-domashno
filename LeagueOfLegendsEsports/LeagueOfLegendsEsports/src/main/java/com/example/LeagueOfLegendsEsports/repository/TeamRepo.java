package com.example.LeagueOfLegendsEsports.repository;

import com.example.LeagueOfLegendsEsports.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {

}
