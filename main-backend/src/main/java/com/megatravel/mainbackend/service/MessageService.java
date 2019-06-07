package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Message;
import com.megatravel.mainbackend.repository.MessageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface MessageService {

	List<Message> findAll();
    Message save(Message message);
    void delete(Long id);
}
