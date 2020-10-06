package com.casino;

import com.casino.entity.Casino;
import com.casino.entity.Game;
import com.casino.entity.GameConfiguration;
import com.casino.entity.GameType;
import com.casino.service.CasinoService;
import com.casino.service.GameService;
import com.casino.service.PlayerService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasinoLoader {
    @Autowired
    private CasinoService casinoService;
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;
    private static final Logger LOGGER = Logger.getLogger(CasinoLoader.class.getName());

    public CasinoLoader() {
    }

    @PostConstruct
    private void init() {
        this.generateMocks();
    }

    public void generateMocks() {
        GameConfiguration configPokerEasy = new GameConfiguration(GameType.POKER, 30.0F, 100.0F, 15.0F, 60.0F, 360.0D);
        GameConfiguration configPokerMedium = new GameConfiguration(GameType.POKER, 15.0F, 200.0F, 45.0F, 120.0F, 360.0D);
        GameConfiguration configPokerHard = new GameConfiguration(GameType.POKER, 7.0F, 300.0F, 60.0F, 180.0F, 360.0D);
        List<GameConfiguration> pokerConfigurations = new ArrayList();
        pokerConfigurations.add(configPokerEasy);
        pokerConfigurations.add(configPokerMedium);
        pokerConfigurations.add(configPokerHard);
        Game poker = new Game(GameType.POKER, pokerConfigurations);
        List<Game> gamesCasino = new ArrayList();
        gamesCasino.add(poker);
        Casino casinoMock = new Casino(gamesCasino);
        Casino casino = this.casinoService.save(casinoMock);
        LOGGER.info("Casino " + this.casinoService.showGames(this.casinoService.getById(casino.getId())));
    }
}
