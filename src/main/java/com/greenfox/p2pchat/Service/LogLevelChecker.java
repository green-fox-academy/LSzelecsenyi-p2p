package com.greenfox.p2pchat.Service;

import com.greenfox.p2pchat.model.Log;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public class LogLevelChecker {

    public boolean checkLogLevel() {
        return System.getenv("CHAT_APP_LOGLEVEL").equals("INFO");
    }

    public void printErrorLog(HttpServletRequest request) {
        Log log = new Log(request);
        log.setLogLevel("ERROR");
        String logMessage = log.toString();
        System.err.println(logMessage);
    }

    public void printNormalLog(HttpServletRequest request) {
        if (checkLogLevel()) {
            Log log = new Log(request);
            String logMessage = log.toString();
            System.out.println(logMessage);
        }
    }
}
