package com.github.Kuj0j0taro123.umbrellachatprototype.service;

import com.github.Kuj0j0taro123.umbrellachatprototype.dao.ChatMessageRepository;
import com.github.Kuj0j0taro123.umbrellachatprototype.entity.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageServiceImpl implements ChatMessageService{

    private ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageServiceImpl(ChatMessageRepository theChatMessageRepository){
        this.chatMessageRepository = theChatMessageRepository;
    }

    @Override
    public List<ChatMessage> findAll() {
        return chatMessageRepository.findAll();
    }

    @Override
    public ChatMessage findById(int theId) {
        Optional<ChatMessage> result = chatMessageRepository.findById(theId);

        ChatMessage theChatMessage = null;

        if (result.isPresent()){
            theChatMessage = result.get();
        }
        else{
            throw new RuntimeException("Message" + theId + "not found");
        }

        return theChatMessage;
    }

    @Override
    public void save(ChatMessage theChatMessage) {
        chatMessageRepository.save(theChatMessage);
    }

    @Override
    public void deleteById(int theId) {
        chatMessageRepository.deleteById(theId);
    }
}
