package com.greenfox.p2pchat.controller;

import com.greenfox.p2pchat.Service.LogLevelChecker;
import com.greenfox.p2pchat.Service.UserHandler;
import com.greenfox.p2pchat.model.ChatMessage;
import com.greenfox.p2pchat.model.ChatUser;
import com.greenfox.p2pchat.repository.ChatUserRepository;
import com.greenfox.p2pchat.repository.MessageRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatUserRepository chatUserRepository;

    @Autowired
    LogLevelChecker logLevelChecker;

    @Autowired
    UserHandler userHandler;

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping({"/", ""})
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("users", chatUserRepository.findAll());
        model.addAttribute("activeUser", userHandler.getActiveUser());
        logLevelChecker.printNormalLog(request);
        if (chatUserRepository.count() == 0){
            return "enter2";
        } else return "index2";
    }

    @GetMapping("/enter")
    public String enterPage(HttpServletRequest request) {
        logLevelChecker.printNormalLog(request);
        return "enter2";
    }

    @PostMapping("/adduser")
    public String addUser(@RequestParam("name") String name,
                          Model model,
                          HttpServletRequest request) {
        model.addAttribute("messages", messageRepository.findAll());
        String warnMessage = "";
        if (userHandler.checkExistingUser(name)) {
            userHandler.setActiveUser(chatUserRepository.findChatUserByName(name));
            logLevelChecker.printNormalLog(request);
            return "redirect:/chat";
        } else if(userHandler.checkEmptyInputField(name)) {
            warnMessage = "The username field is empty";
            model.addAttribute("warnMessage", warnMessage);
            logLevelChecker.printErrorLog(request);
            return "enter2";
        } else
            chatUserRepository.save(new ChatUser(name));
            userHandler.setActiveUser(chatUserRepository.findChatUserByName(name));
            logLevelChecker.printNormalLog(request);
            return "redirect:/chat";
    }

    @PostMapping("/edituser")
    public String editUser(@RequestParam("name") String name, Model model, HttpServletRequest request) {
        model.addAttribute("activeUser", userHandler.getActiveUser());
        userHandler.getActiveUser().setName(name);
        chatUserRepository.save(userHandler.getActiveUser());
        logLevelChecker.printNormalLog(request);
        return "index2";
    }

    @PostMapping("/addmessage")
    public String addMessage(@RequestParam("text") String text, HttpServletRequest request) {
        messageRepository.save(new ChatMessage(userHandler.getActiveUser(), text));
        logLevelChecker.printNormalLog(request);
        return "index2";
    }

}
