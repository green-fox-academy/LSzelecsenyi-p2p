package com.greenfox.p2pchat.model;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String path;
    private String method;
    private String dateTime;
    private String logLevel;
    private String requestData;

    public Log() {
    }

    public Log(HttpServletRequest request, String requestData) {
        this.path = request.getServletPath();
        this.method = request.getMethod();
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.requestData = request.getQueryString();
    }

    public Log(HttpServletRequest request) {
        this.path = request.getServletPath();
        this.method = request.getMethod();
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
    }

    @Override
    public String toString() {
        if (requestData == null) {
            return dateTime + " " + logLevel + " " + path + " " + method + "\n";
        } else {
            return dateTime + " " + logLevel + " " + path + " " + method + " " + requestData + "\n";
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }
}
