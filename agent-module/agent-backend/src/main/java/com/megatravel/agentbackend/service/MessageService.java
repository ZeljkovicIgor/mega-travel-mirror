package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.MessageDto;
import com.megatravel.agentbackend.model.Message;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;

import java.util.List;

public interface MessageService {

    List<Message> getAll();
    List<Message> getAgentMessages(User agent);
    List<Message> getUserMessages(User user);
    List<Message> getAgentUserMessages(User agent, User user);
    List<Message> getUserAgentMessages(User user, User agent);
    List<Message> getReservationMessages(Reservation reservation);
    List<Message> getReservationMessagesById(Long id);
    Message getOneById(Long id);
    Message addOne(Message message);
    Message editOne(Message message);
    MessageDto sendMessage(MessageDto messageDto);
    boolean deleteOne(Message message);
    boolean deleteById(Long id);
    //convertFromDto();
    //convertToDto();
}
