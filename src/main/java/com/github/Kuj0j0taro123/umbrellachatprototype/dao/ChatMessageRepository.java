package com.github.Kuj0j0taro123.umbrellachatprototype.dao;

import com.github.Kuj0j0taro123.umbrellachatprototype.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {
}
