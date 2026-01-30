package com.example.news.repository;

import com.example.news.entity.News;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsRepository extends JpaRepository<@NonNull News, @NonNull UUID> {}
