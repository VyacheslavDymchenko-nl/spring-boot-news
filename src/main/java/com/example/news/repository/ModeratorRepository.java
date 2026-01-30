package com.example.news.repository;

import com.example.news.entity.Moderator;
import com.example.news.entity.ModeratorId;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeratorRepository extends JpaRepository<@NonNull Moderator, @NonNull ModeratorId> {}
