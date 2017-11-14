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
    private String user;
    private String text;
    private LocalDateTime timestamp;

    public ChatMessage(String user, String text) {
        this.user = user;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
