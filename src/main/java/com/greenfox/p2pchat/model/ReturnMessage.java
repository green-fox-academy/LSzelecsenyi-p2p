package com.greenfox.p2pchat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ReturnMessage {
    private String status;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String message;

    public ReturnMessage() {
    }

    public ReturnMessage(String status) {

        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
