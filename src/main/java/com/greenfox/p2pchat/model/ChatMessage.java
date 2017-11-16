package com.greenfox.p2pchat.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
@Entity
@Table(name = "messages")
public class ChatMessage {

    @Id
    private Long id;
    private String text;
    private String username;
    private Timestamp timestamp;

    public ChatMessage() {

    }

    public ChatMessage(String text) {
        this.text = text;
    }

    public ChatMessage(String text, String chatUser) {
        this.text = text;
        this.username = chatUser;
        this.id = 1000000 + (long) (Math.random() * (9999999L - 1000000L));
        timestamp = Timestamp.valueOf(LocalDateTime.now());
    }

    public ChatMessage(Long id, String text, String chatUser, Timestamp timestamp) {
        this.id = id;
        this.text = text;
        this.username = chatUser;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
