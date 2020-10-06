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
        name = "providers"
)
public class Provider {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private UUID id;
    private String name;

    public Provider() {
    }

    public Provider(String name) {
        this.name = name;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Provider{id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}
