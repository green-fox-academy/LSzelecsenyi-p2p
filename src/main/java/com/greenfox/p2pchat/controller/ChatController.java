package com.greenfox.p2pchat.controller;

import com.greenfox.p2pchat.Service.LogLevelChecker;
import com.greenfox.p2pchat.model.ChatUser;
import com.greenfox.p2pchat.model.Log;
import com.greenfox.p2pchat.repository.ChatUserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatUserRepository chatUserRepository;

    @Autowired
    LogLevelChecker logLevelChecker;

    @RequestMapping({"/", ""})
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("users", chatUserRepository.findAll());
        logLevelChecker.printNormalLog(request);
        if (chatUserRepository.count() == 0){
            return "enter";
        } else return "index";
    }

    @GetMapping("/enter")
    public String enterPage(HttpServletRequest request) {
        logLevelChecker.printNormalLog(request);
        return "enter";
    }

    @PostMapping("/adduser")
    public String addUser(@RequestParam("name") String name, HttpServletRequest request) {
        if (chatUserRepository.findChatUserByName(name) != null) {
            logLevelChecker.printNormalLog(request);
            return "redirect:/chat";
        } else {
            chatUserRepository.save(new ChatUser(name));
            logLevelChecker.printNormalLog(request);
        }
        return "redirect:/chat";
    }

}
