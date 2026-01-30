package com.example.news.entity.superclass;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity {
    @Column(name = "moderated_by")
    protected UUID moderatedBy;
    @Column(name = "creation_time")
    protected Long creationTime;
    @Column(name = "last_modified_time")
    protected Long lastModifiedTime;

    public AbstractEntity(UUID moderatedBy) {
        this.moderatedBy = moderatedBy;
    }

    protected AbstractEntity() {
    }

    public UUID getModeratedBy() {
        return moderatedBy;
    }

    public void setModeratedBy(UUID moderatedBy) {
        this.moderatedBy = moderatedBy;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    public Long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
