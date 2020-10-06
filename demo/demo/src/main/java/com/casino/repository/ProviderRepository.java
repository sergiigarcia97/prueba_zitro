package com.casino.repository;

import com.casino.entity.Provider;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID> {
}
