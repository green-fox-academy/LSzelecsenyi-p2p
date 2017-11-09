package com.greenfox.p2pchat.repository;

import com.greenfox.p2pchat.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Message, Long> {
}
