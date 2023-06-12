package com.example.LeagueOfLegendsEsports.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class Commentator {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "commentators")
    private List<Game> gamesCommentated;

    private String languages;//езиците на коментатора ще са разделени чрез запетаи в един стринг защото иначе SQL прави проблем и това е сравнително чисто решение

    public List<String> getLanguagesAsList() {
        return Arrays.asList(this.languages.split(","));
    }

    public void setLanguagesFromList(List<String> languages) {
        this.languages = String.join(",", languages);
    }

}
