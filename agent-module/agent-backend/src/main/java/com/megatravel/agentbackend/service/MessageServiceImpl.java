package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Message;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getAgentMessages(User agent) {
        List<Message> messages = new ArrayList<>();
        messages.addAll(messageRepository.findByMessageSenderOrMessageReciever(agent, agent));
        return null;
    }

    @Override
    public List<Message> getUserMessages(User user) {
        return messageRepository.findByMessageSenderOrMessageReciever(user, user);
    }

    @Override
    public List<Message> getAgentUserMessages(User agent, User user) {
        return messageRepository.findByMessageSenderAndMessageReciever(agent, user);
    }

    @Override
    public List<Message> getUserAgentMessages(User user, User agent) {
        return messageRepository.findByMessageSenderAndMessageReciever(user, agent);
    }

    @Override
    public List<Message> getReservationMessages(Reservation reservation) {
        return messageRepository.findByMessageReservation(reservation);
    }

    @Override
    public Message getOneById(Long id) {
        return messageRepository.getOne(id);
    }

    @Override
    public Message addOne(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message editOne(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public boolean deleteOne(Message message) {
        messageRepository.delete(message);
        return (messageRepository.existsById(message.getMessageId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        messageRepository.deleteById(id);
        return (messageRepository.existsById(id)?true:false);
    }
}
