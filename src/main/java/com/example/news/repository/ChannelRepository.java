package com.example.news.repository;

import com.example.news.entity.Channel;
import org.jspecify.annotations.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ChannelRepository extends CrudRepository<@NonNull Channel, @NonNull UUID> {}
