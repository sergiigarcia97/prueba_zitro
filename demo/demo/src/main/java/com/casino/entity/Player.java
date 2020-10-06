package com.casino.entity;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "players"
)
public class Player {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private UUID id;
    private Float balance;
    private Float time;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "provider_id",
            referencedColumnName = "id"
    )
    private Provider provider;

    public Player() {
    }

    public Player(Float balance, Float time, Provider provider) {
        this.balance = balance;
        this.time = time;
        this.provider = provider;
    }

    public UUID getId() {
        return this.id;
    }

    public Float getBalance() {
        return this.balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getTime() {
        return this.time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String toString() {
        return "Player{id=" + this.id + ", balance=" + this.balance + ", time=" + this.time + ", provider=" + this.provider + '}';
    }
}
