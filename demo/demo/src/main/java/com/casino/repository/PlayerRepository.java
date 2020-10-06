package com.casino.repository;

import com.casino.entity.Player;
import com.casino.entity.Provider;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    List<Player> findByProvider(Provider provider);
}
