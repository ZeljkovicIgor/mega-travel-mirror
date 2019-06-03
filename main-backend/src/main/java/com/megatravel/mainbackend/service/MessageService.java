package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Message;
import com.megatravel.mainbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface MessageService {

    Message addMessage(Message message);
}
