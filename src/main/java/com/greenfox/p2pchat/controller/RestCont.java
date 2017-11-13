package com.greenfox.p2pchat.controller;

import com.greenfox.p2pchat.Service.LogLevelChecker;
import com.greenfox.p2pchat.model.Log;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"", "/"})
public class RestCont {

    @Autowired
    Log log;

    @Autowired
    LogLevelChecker logLevelChecker;

    @RequestMapping("/log")
    public void showLog(HttpServletRequest request) {
        logLevelChecker.printNormalLog(request);
    }


}
