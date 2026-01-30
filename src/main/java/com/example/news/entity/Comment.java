package com.example.news.entity;

import com.example.news.entity.superclass.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.util.UUID;

@Entity
@IdClass(CommentId.class)
public class Comment extends AbstractEntity {
    @Id
    private UUID userId;
    @Id
    private UUID newsId;
    @Column(nullable = false)
    private String text;

    public Comment(UUID moderatedBy, UUID userId, UUID newsId, String text) {
        super(moderatedBy);
        this.userId = userId;
        this.newsId = newsId;
        this.text = text;
    }

    protected Comment() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getNewsId() {
        return newsId;
    }

    public void setNewsId(UUID newsId) {
        this.newsId = newsId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
