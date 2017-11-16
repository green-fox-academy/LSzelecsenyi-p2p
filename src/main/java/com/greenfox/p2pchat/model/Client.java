package com.greenfox.p2pchat.model;

public class Client {

    public Client() {
        this.id = System.getenv("CHAT_APP_UNIQUE_ID");
    }

    public Client(String id) {

        this.id = id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
