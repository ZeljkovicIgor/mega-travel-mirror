package com.megatravel.mainbackend.service;

import com.megatravel.mainbackend.model.Message;
import com.megatravel.mainbackend.repository.MessageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;


    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }


	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return messageRepository.findAll();
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		messageRepository.deleteById(id);
	}
	
	@Override
	public List<Message> findBySender_id(Long id) {
		// TODO Auto-generated method stub
		return messageRepository.findByMessageSenderUserId(id);
	}


	@Override
	public List<Message> findByReciever_id(Long id) {
		// TODO Auto-generated method stub
		return messageRepository.findByMessageRecieverUserId(id);
	}
	
	
}
