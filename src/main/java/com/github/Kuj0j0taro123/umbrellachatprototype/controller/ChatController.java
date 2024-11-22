package com.github.Kuj0j0taro123.umbrellachatprototype.controller;

import org.springframework.ui.Model;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String chat(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        System.out.println(model.getAttribute("username"));
        return "chat";
    }



    @MessageMapping("/sendMessage") // Maps to /app/sendMessage
    @SendTo("/topic/messages") // Broadcasts to /topic/messages
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }



    public static class ChatMessage {
        private String username;
        private String content;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}