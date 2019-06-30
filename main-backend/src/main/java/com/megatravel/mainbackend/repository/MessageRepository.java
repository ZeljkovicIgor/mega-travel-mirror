package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.Message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	List<Message> findByMessageSenderUserId(Long id);
	List<Message> findByMessageRecieverUserId(Long id);

}
