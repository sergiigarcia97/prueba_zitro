package com.casino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "game_configuration"
)
public class GameConfiguration {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private GameType gameType;
    private Float probability;
    private Float reward;
    private Float minBet;
    private Float maxBet;
    private Double duration;

    public GameConfiguration() {
    }

    public GameConfiguration(GameType gameType, Float probability, Float reward, Float minBet, Float maxBet, Double duration) {
        this.gameType = gameType;
        this.probability = probability;
        this.reward = reward;
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.duration = duration;
    }

    public Long getId() {
        return this.id;
    }

    public GameType getGameType() {
        return this.gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Float getProbability() {
        return this.probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public Float getReward() {
        return this.reward;
    }

    public void setReward(Float reward) {
        this.reward = reward;
    }

    public Float getMinBet() {
        return this.minBet;
    }

    public void setMinBet(Float minBet) {
        this.minBet = minBet;
    }

    public Float getMaxBet() {
        return this.maxBet;
    }

    public void setMaxBet(Float maxBet) {
        this.maxBet = maxBet;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
