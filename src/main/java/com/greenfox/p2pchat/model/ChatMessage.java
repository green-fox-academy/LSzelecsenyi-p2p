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
    private long id;
    private String text;
    private String chatUser;
    private Timestamp timestamp;

    public ChatMessage() {

    }

    public ChatMessage(String text, String chatUser) {
        this.text = text;
        this.chatUser = chatUser;
        this.id = 1000000 + (long) (Math.random() * (9999999L - 1000000L));
        timestamp = Timestamp.valueOf(LocalDateTime.now());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChatUser() {
        return chatUser;
    }

    public void setChatUser(String chatUser) {
        this.chatUser = chatUser;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", chatUser='" + chatUser + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
