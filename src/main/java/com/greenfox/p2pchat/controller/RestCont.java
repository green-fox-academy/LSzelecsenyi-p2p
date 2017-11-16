package com.greenfox.p2pchat.controller;

import com.greenfox.p2pchat.Service.LogLevelChecker;
import com.greenfox.p2pchat.model.*;
import com.greenfox.p2pchat.repository.MsgRepo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"", "/"})
public class RestCont {

    @Autowired
    Log log;

    @Autowired
    LogLevelChecker logLevelChecker;

    @Autowired
    MsgRepo msgRepo;

    @RequestMapping("/log")
    public void showLog(HttpServletRequest request) {
        logLevelChecker.printNormalLog(request);
    }

    @CrossOrigin("*")
    @PostMapping("/api/message/receive")
    public Object receive(@RequestBody Request jsonObject) {
        ReturnMessage message = new ReturnMessage();
        if (jsonObject.getChatMessage().getText() != null && jsonObject.getChatMessage().getUsername() != null && jsonObject.getChatMessage().getTimestamp() != null && jsonObject.getClient().getId() != null) {
            message.setStatus("ok");
            message.setMessage("");
            return message;
        } else {
            message.setMessage("Missing Field(s): ");
            message.setStatus("Error");
            if (jsonObject.getChatMessage().getText() == null) {
                message.setMessage(message.getMessage() + " chatMessage.text");
            }
            if (jsonObject.getChatMessage().getUsername() == null) {
                message.setMessage(message.getMessage() + " chatMessage.chatUser");
            }
            if (jsonObject.getChatMessage().getTimestamp() == null) {
                message.setMessage(message.getMessage() + " chatMessage.timestamp");
            }
            if (jsonObject.getClient().getId() == null) {
                message.setMessage(message.getMessage() + " client.id");
            }
            return message;
        }
    }

}
