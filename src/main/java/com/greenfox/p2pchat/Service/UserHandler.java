package com.greenfox.p2pchat.Service;

import com.greenfox.p2pchat.model.ChatUser;
import com.greenfox.p2pchat.repository.ChatUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

    @Autowired
    ChatUserRepo chatUserRepository;

    private ChatUser activeUser;

    public ChatUserRepo getChatUserRepository() {
        return chatUserRepository;
    }

    public boolean checkEmptyInputField(String field) {
        return field.equals("");
    }

    public boolean checkExistingUser(String name) {
        return chatUserRepository.findChatUserByName(name) != null;
    }

    public boolean checkActiveUser() {
        return activeUser == null;
    }

    public ChatUser getActiveUser() {
        return activeUser;
    }

    public String getActiveUserName() {
        return activeUser.getName();
    }

    public void setActiveUser(ChatUser activeUser) {
        this.activeUser = activeUser;
    }
}
