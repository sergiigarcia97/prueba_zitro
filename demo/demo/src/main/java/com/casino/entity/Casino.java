package com.casino.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "casino"
)
public class Casino {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @OneToMany
    private List<Player> players;
    @OneToMany(
            fetch = FetchType.EAGER
    )
    private List<Game> games;

    public Casino() {
    }

    public Casino(List<Player> players, List<Game> games) {
        this.players = players;
        this.games = games;
    }

    public Casino(List<Game> games) {
        this.games = games;
    }

    public Long getId() {
        return this.id;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Game> getGames() {
        return this.games;
    }

    public void setGames(List<Game> game) {
        this.games = game;
    }

    public String toString() {
        return "Casino{id=" + this.id + ", players=" + this.players + ", games=" + this.games + '}';
    }
}
