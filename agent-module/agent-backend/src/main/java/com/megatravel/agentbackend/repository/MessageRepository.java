package com.megatravel.agentbackend.repository;

import com.megatravel.agentbackend.model.Message;
import com.megatravel.agentbackend.model.Reservation;
import com.megatravel.agentbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByMessageSender(User messageSender);
    List<Message> findByMessageReciever(User messageReciever);
    List<Message> findByMessageSenderAndMessageReciever(User messageSender, User messageReciever);
    List<Message> findByMessageReservation(Reservation messageReservation);
    List<Message> findByMessageSenderOrMessageReciever(User messageSender, User messageReciever);
    Message findByMessageDbId(Long id);

}
