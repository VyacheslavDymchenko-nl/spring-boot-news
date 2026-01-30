package com.example.news.entity;

import java.io.Serializable;
import java.util.UUID;

public class ModeratorId implements Serializable {
    private UUID userId;
    private UUID channelId;

    public ModeratorId(UUID userId, UUID channelId) {
        this.userId = userId;
        this.channelId = channelId;
    }

    public ModeratorId() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
