package com.greenfox.p2pchat.controller;

import com.greenfox.p2pchat.model.Log;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"", "/"})
public class RestCont {

    @RequestMapping("/log")
    public void showLog(HttpServletRequest request) {
        System.out.println(new Log(request));
    }


}
