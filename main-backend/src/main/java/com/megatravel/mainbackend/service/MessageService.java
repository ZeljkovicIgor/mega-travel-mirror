package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Message;

import java.util.List;

public interface MessageService {

	List<Message> findAll();
    Message save(Message message);
    void delete(Long id);
    
    List<Message> findBySender_id(Long id);
	List<Message> findByReciever_id(Long id);
}
