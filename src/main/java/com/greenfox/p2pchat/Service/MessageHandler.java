package com.greenfox.p2pchat.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MessageHandler {

    public Integer getRandomInt() {
        Random r = new Random();
        Integer random = r.nextInt(9999999) + 1000000;
        return random;
    }
}
