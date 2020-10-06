package com.casino.service;

import com.casino.entity.Player;
import com.casino.entity.Provider;
import com.casino.repository.PlayerRepository;
import com.casino.repository.ProviderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ProviderRepository providerRepository;

    public PlayerService() {
    }

    public Player save(Player player) {
        return (Player)this.playerRepository.save(player);
    }

    public List<Player> getByProvider(Provider provider) {
        return this.playerRepository.findByProvider(provider);
    }

    public List<Player> getAllPlayers() {
        return this.playerRepository.findAll();
    }
}
