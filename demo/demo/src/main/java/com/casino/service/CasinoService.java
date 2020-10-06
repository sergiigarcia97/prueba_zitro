package com.casino.service;

import com.casino.entity.Casino;
import com.casino.entity.Game;
import com.casino.entity.GameConfiguration;
import com.casino.repository.CasinoRepository;
import com.casino.repository.MoveRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasinoService {
    @Autowired
    private CasinoRepository casinoRepository;
    @Autowired
    private MoveRepository moveRepository;
    @Autowired
    private GameService gameService;

    public CasinoService() {
    }

    public Casino getById(Long idCasino) {
        return (Casino)this.casinoRepository.findById(idCasino).get();
    }

    public List<Game> showGames(Casino casino) {
        return ((Casino)this.casinoRepository.findById(casino.getId()).get()).getGames();
    }

    public List<GameConfiguration> showGameConfigurationOfGametype(Long idCasino, Game game) {
        return this.gameService.getGameConfigurationByGame(game);
    }

    public Casino save(Casino casino) {
        casino.getGames().forEach((game) -> {
            this.gameService.save(game);
        });
        return (Casino)this.casinoRepository.save(casino);
    }
}