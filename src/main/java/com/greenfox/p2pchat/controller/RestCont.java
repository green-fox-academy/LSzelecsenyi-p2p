package com.greenfox.p2pchat.controller;

import com.greenfox.p2pchat.model.Log;
import com.greenfox.p2pchat.model.Message;
import com.greenfox.p2pchat.repository.ChatRepository;
import com.greenfox.p2pchat.repository.LogRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping({"", "/"})
public class RestCont {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private LogRepository logRepository;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/savemessage")
    public Message postMessage(@RequestParam("message") String message) {
        Message firstMessage = new Message(message);
        chatRepository.save(firstMessage);
        return firstMessage;
    }

    @RequestMapping("/seelog")
    public Log home(HttpServletRequest request) {
        Log log = new Log(request);
        logRepository.save(log);
        System.out.println(log);
        return log;
    }



}
