package com.example.news.repository;

import com.example.news.entity.User;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UserRepository extends JpaRepository<@NonNull User, @NonNull UUID> {

}
