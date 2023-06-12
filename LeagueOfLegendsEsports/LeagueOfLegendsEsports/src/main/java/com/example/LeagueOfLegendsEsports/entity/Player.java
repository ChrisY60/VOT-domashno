package com.example.LeagueOfLegendsEsports.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String nickname;
    private String role;

    @ManyToOne
    private Team team;
}
