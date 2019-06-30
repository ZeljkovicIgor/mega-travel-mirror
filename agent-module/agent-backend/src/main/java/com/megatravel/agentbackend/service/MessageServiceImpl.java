package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.MessageDto;
import com.megatravel.agentbackend.model.Message;
import com.megatravel.agentbackend.model.MessageStatus;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ReservationService reservationService;
    @Autowired
    UserService userService;
    @Autowired
    HttpSession httpSession;
    @Autowired
    SoapService soapService;

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
    public List<Message> getReservationMessagesById(Long id) {
        Reservation reservation = reservationService.getOneById(id);

        return messageRepository.findByMessageReservation(reservation);
    }

    @Override
    public Message getOneById(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public Message getOneByDbId(Long id) {
        return messageRepository.findByMessageDbId(id);
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
    public MessageDto sendMessage(MessageDto messageDto, User agent) {
        agent = userService.getOneById(agent.getUserId());
        User user = userService.getOneByUsername(messageDto.getMessageRecieverUsername());
        Reservation res = reservationService.getOneById(messageDto.getMessageReservationId());
        Message message = new Message();
        message.setMessageContent(messageDto.getMessageContent());
        message.setMessageDate(messageDto.getMessageDate());
        message.setMessageReciever(user);
        message.setMessageSender(agent);
        message.setMessageReservation(res);
        message.setStatus(MessageStatus.SENT);
        //message = messageRepository.save(message);
        messageDto.setMessageId(message.getMessageId());
        messageDto.setStatus(MessageStatus.SENT);

        soapService.sendMessage(message);

        return messageDto;
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

    @Override
    public void deleteAll() {
        messageRepository.deleteAll();
    }
}
