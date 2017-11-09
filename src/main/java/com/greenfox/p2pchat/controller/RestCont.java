package com.greenfox.p2pchat.controller;

import com.greenfox.p2pchat.model.Message;
import com.greenfox.p2pchat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCont {

    @Autowired
    private ChatRepository chatRepository;

    @PostMapping("/savemessage}")
    public Message postMessage(@RequestParam("message") String message) {
        Message firstMessage = new Message(message);
        chatRepository.save(firstMessage);
        return firstMessage;
    }
}
