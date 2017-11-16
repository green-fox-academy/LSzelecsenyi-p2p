package com.greenfox.p2pchat.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonProperty("username")
    private String chatUser;

    public ChatUser() {
    }

    public ChatUser(String username) {

        this.chatUser = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return chatUser;
    }

    public void setUsername(String username) {
        this.chatUser = username;
    }

    @Override
    public String toString() {
        return chatUser;
    }
}
