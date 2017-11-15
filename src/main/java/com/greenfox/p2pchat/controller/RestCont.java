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

    @PostMapping("/api/message/receive")
    public Object receive(@RequestBody JsonObject jsonObject) {
        ReturnMessage message = new ReturnMessage();
        if (!jsonObject.getChatMessage().getText().equals("") && !jsonObject.getChatMessage().getChatUser().equals("") && !jsonObject.getChatMessage().getTimestamp().equals("") && !jsonObject.getClient().getId().equals("")) {
            message.setStatus("ok");
            message.setMessage("");
            return message;
        } else {
            message.setMessage("Missing Field(s): ");
            message.setStatus("Error");
            if (jsonObject.getChatMessage().getText().equals("")) {
                message.setMessage(message.getMessage() + " chatMessage.text");
            }
            if (jsonObject.getChatMessage().getChatUser().equals("")) {
                message.setMessage(message.getMessage() + " chatMessage.chatUser");
            }
            if (jsonObject.getChatMessage().getTimestamp() == null) {
                message.setMessage(message.getMessage() + " chatMessage.timestamp");
            }
            if (jsonObject.getClient().getId().equals("")) {
                message.setMessage(message.getMessage() + " client.id");
            }
            return message;
        }
    }

//    HttpStatus.OK
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ReturnMessage paramError (MissingServletRequestParameterException missingParam){
//        ReturnMessage response = new ReturnMessage();
//        response.setMessage("Missing field(s): ");
//        if (missingParam.getParameterName().equals("timestamp")) {
//            response.setMessage(response.getMessage() + " message.timestamp");
//        } else if (missingParam.getParameterName().equals("text")) {
//            response.setMessage(response.getMessage() + " message.text");
//        } else if (missingParam.getParameterName().equals("chatUser")) {
//            response.setMessage(response.getMessage() + " message.chatUser");
//        } else if (missingParam.getParameterName().equals("id")) {
//            response.setMessage(response.getMessage() + " message.id");
//        } else if (missingParam.getParameterName().equals("clientId")) {
//            response.setMessage(response.getMessage() + " client.id");
//        }
//        return response;
//    }



}
