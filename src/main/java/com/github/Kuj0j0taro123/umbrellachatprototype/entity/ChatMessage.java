package com.github.Kuj0j0taro123.umbrellachatprototype.entity;

import jakarta.persistence.*;

@Entity
@Table(name="chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="content")
    private String content;

    public ChatMessage(){}

    public ChatMessage(String theUsername, String theContent){
        username = theUsername;
        content = theContent;
    }

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

    @Override
    public String toString() {
        return "ChatMessage{" +
                "username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
