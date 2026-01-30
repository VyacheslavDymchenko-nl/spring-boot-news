package com.example.news.entity;

import com.example.news.entity.superclass.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.util.UUID;

@Entity
@IdClass(ModeratorId.class)
public class Moderator extends AbstractEntity {
    @Id
    private UUID userId;
    @Id
    private UUID channelId;

    public Moderator(UUID moderatedBy, UUID userId, UUID channelId) {
        super(moderatedBy);
        this.userId = userId;
        this.channelId = channelId;
    }

    protected Moderator() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getChannelId() {
        return channelId;
    }

    public void setChannelId(UUID channelId) {
        this.channelId = channelId;
    }
}
