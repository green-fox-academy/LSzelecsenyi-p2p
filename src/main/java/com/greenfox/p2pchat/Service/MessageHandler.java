package com.greenfox.p2pchat.Service;

import com.greenfox.p2pchat.model.ChatMessage;
import com.greenfox.p2pchat.model.Client;
import com.greenfox.p2pchat.model.Request;
import com.greenfox.p2pchat.model.ReturnMessage;
import com.greenfox.p2pchat.repository.MsgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageHandler {

    @Autowired
    MsgRepo msgRepo;

    public void saveMessage(ChatMessage message) {
        msgRepo.save(message);
    }

    public void postMessage(ChatMessage message) {
        Request request = new Request(message, new Client());
        RestTemplate template = new RestTemplate();
        String url = System.getenv("CHAT_APP_PEER_ADDRESS");
        ReturnMessage response = template.postForObject(url, request, ReturnMessage.class);
        System.out.println(response.getStatus());
        System.out.println(response.getMessage());
    }

}
