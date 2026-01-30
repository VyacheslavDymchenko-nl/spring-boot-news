package com.example.news.entity;

import java.io.Serializable;
import java.util.UUID;


public class ReactionId implements Serializable {
    private UUID newsId;
    private UUID userId;

    public ReactionId(UUID newsId, UUID userId) {
        this.newsId = newsId;
        this.userId = userId;
    }

    public ReactionId() {
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
