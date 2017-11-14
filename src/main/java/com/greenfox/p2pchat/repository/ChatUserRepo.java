package com.greenfox.p2pchat.repository;

import com.greenfox.p2pchat.model.ChatUser;
import org.springframework.data.repository.CrudRepository;

public interface ChatUserRepo extends CrudRepository<ChatUser, Long> {

    public ChatUser findChatUserByName(String name);
}
