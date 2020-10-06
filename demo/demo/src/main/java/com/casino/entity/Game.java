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
        name = "games"
)
public class Game {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private GameType type;
    @OneToMany(
            fetch = FetchType.EAGER
    )
    private List<GameConfiguration> gameConfigurations;

    public Game() {
    }

    public Game(GameType type, List<GameConfiguration> gameConfigurations) {
        this.type = type;
        this.gameConfigurations = gameConfigurations;
    }

    public Long getId() {
        return this.id;
    }

    public GameType getType() {
        return this.type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public List<GameConfiguration> getGameConfigurations() {
        return this.gameConfigurations;
    }

    public void setGameConfigurations(List<GameConfiguration> gameConfigurations) {
        this.gameConfigurations = gameConfigurations;
    }

    public String toString() {
        return "Game{id=" + this.id + ", type='" + this.type + '\'' + ", gameConfigurations=" + this.gameConfigurations + '}';
    }
}
