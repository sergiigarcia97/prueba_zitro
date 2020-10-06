package com.casino.service;

import com.casino.entity.Game;
import com.casino.entity.GameConfiguration;
import com.casino.entity.GameType;
import com.casino.repository.GameConfigurationRepository;
import com.casino.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameConfigurationRepository gameConfigurationRepository;

    public GameService() {
    }

    public Game save(Game game) {
        game.getGameConfigurations().forEach((gameConfiguration) -> {
            this.gameConfigurationRepository.save(gameConfiguration);
        });
        return (Game)this.gameRepository.save(game);
    }

    public List<Game> getByGametype(GameType gameType) {
        return this.gameRepository.findByType(gameType);
    }

    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }

    public List<GameConfiguration> getGameConfigurationByGame(Game game) {
        return this.gameRepository.findGameconfigurationByType(game.getType());
    }

    public Game getGameById(Long idGame) {
        return (Game)this.gameRepository.findById(idGame).get();
    }
}