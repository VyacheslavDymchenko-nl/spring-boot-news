package com.example.news.entity;

import com.example.news.entity.superclass.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.util.UUID;

@Entity
@IdClass(ReactionId.class)
public class Reaction extends AbstractEntity {
    @Id
    private UUID newsId;
    @Id
    private UUID userId;
    private String type;

    public Reaction(UUID moderatedBy, UUID newsId, UUID userId, String type) {
        super(moderatedBy);
        this.newsId = newsId;
        this.userId = userId;
        this.type = type;
    }

    protected Reaction() {
    }

    public UUID getNewsId() {
        return newsId;
    }

    public void setNewsId(UUID newsId) {
        this.newsId = newsId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
