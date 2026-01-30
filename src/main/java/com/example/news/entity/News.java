package com.example.news.entity;

import com.example.news.entity.superclass.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;


@Entity
public class News extends AbstractEntity {
    @Id
    private UUID id;
    private UUID authorId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String category;
    private UUID channelId;

    public News(UUID moderatedBy, UUID authorId, String title, String content, String category, UUID channelId) {
        super(moderatedBy);
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.category = category;
        this.channelId = channelId;
    }

    protected News() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UUID getChannelId() {
        return channelId;
    }

    public void setChannelId(UUID channelId) {
        this.channelId = channelId;
    }
}
