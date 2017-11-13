package com.greenfox.p2pchat.controller;

import com.greenfox.p2pchat.model.Log;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping({"/", ""})
    public String index(HttpServletRequest request) {
        System.out.println(new Log(request));
        return "index";
    }

}
