package com.greenfox.p2pchat.model;

public class JsonObject {

    private ChatMessage chatMessage;
    private Client client;

    public JsonObject() {
    }

    public JsonObject(ChatMessage chatMessage, Client client) {
        this.chatMessage = chatMessage;
        this.client = client;
    }

    public ChatMessage getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
