package com.example.news.entity;

import java.io.Serializable;
import java.util.UUID;

public class CommentId implements Serializable {
    private UUID userId;
    private UUID newsId;

    public CommentId(UUID userId, UUID newsId) {
        this.userId = userId;
        this.newsId = newsId;
    }

    public CommentId() {
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
