package com.casino.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "moves"
)
public class Move {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private UUID id;
    private Integer result;
    private Double transaction;

    public Move() {
    }

    public Move(Integer result, Double transaction) {
        this.result = result;
        this.transaction = transaction;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Double getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Double transaction) {
        this.transaction = transaction;
    }

    public String toString() {
        return "Transacción id=" + this.id + ", result=" + this.result + ", transaction=" + this.transaction + '}';
    }
}
