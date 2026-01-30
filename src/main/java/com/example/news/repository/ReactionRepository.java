package com.example.news.repository;

import com.example.news.entity.Reaction;
import com.example.news.entity.ReactionId;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<@NonNull Reaction, @NonNull ReactionId> {}
