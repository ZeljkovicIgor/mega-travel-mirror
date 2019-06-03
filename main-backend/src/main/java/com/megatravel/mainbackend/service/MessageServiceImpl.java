package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Message;
import com.megatravel.mainbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;


    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }
}
