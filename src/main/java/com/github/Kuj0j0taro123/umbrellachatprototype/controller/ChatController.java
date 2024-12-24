package com.github.Kuj0j0taro123.umbrellachatprototype.controller;

import com.github.Kuj0j0taro123.umbrellachatprototype.entity.ChatMessage;
import com.github.Kuj0j0taro123.umbrellachatprototype.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ChatController {

    private ChatMessageService chatMessageService;

    @Autowired
    ChatController(ChatMessageService theChatMessageService){
        chatMessageService = theChatMessageService;
    }

    @GetMapping("/chat")
    public String chat(Model model, Principal principal) {
        // this gives thymeleaf a model with the username
        // todo: add chat message history here
        model.addAttribute("username", principal.getName());
        System.out.println(model.getAttribute("username"));

        List<ChatMessage> messageHistory = chatMessageService.findAll();
        model.addAttribute("message_history", messageHistory);

        return "chat";
    }



    @MessageMapping("/sendMessage") // Maps to /app/sendMessage
    @SendTo("/topic/messages") // Broadcasts to /topic/messages
    public ChatMessage sendMessage(ChatMessage message) {
        message.setContent(message.getContent());
        chatMessageService.save(message);
        return message;
    }

}