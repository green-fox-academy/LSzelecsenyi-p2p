package com.greenfox.p2pchat.model;

import com.greenfox.p2pchat.Service.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
public class ChatMessage {

    @Autowired
    MessageHandler messageHandler;

    @Id
    private Integer id;
    private ChatUser chatUser;
    private String text;
    private LocalDateTime timestamp;

    public ChatMessage(ChatUser chatUser, String text) {
        this.chatUser = chatUser;
        this.text = text;
        id = messageHandler.getRandomInt();
        timestamp = LocalDateTime.now();
    }

    public ChatMessage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChatUser getUser() {
        return chatUser;
    }

    public void setUser(String user) {
        this.chatUser = chatUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
