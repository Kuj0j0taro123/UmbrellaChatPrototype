package com.github.Kuj0j0taro123.umbrellachatprototype.service;

import com.github.Kuj0j0taro123.umbrellachatprototype.entity.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    List<ChatMessage> findAll();
    ChatMessage findById(int theId);
    void save(ChatMessage theChatMessage);
    void deleteById(int theId);
}
