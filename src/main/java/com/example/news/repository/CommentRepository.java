package com.example.news.repository;

import com.example.news.entity.Comment;
import com.example.news.entity.CommentId;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<@NonNull Comment, @NonNull CommentId> {}
