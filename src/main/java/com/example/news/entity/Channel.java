package com.example.news.entity;

import com.example.news.entity.superclass.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Channel extends AbstractEntity {
    @Id
    private UUID id;
    private UUID authorId;
    private String name;

    public Channel(UUID moderatedBy, UUID authorId, String name) {
        super(moderatedBy);
        this.authorId = authorId;
        this.name = name;
    }

    protected Channel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
