package com.megatravel.agentbackend.dto;

import com.megatravel.agentbackend.model.MessageStatus;

import java.util.Date;

public class MessageDto {

    private long messageId;
    private String messageContent;
    private long messageRecieverId;
    private String messageRecieverUsername;
    private long messageSenderId;
    private long messageReservationId;
    private String messageSenderUsername;
    private Date messageDate;
    private MessageStatus status;

    public MessageDto() {
    }

    public long getMessageId() {
        return messageId;
    }

    public String getMessageRecieverUsername() {

        return messageRecieverUsername;
    }

    public void setMessageRecieverUsername(String messageRecieverUsername) {
        this.messageRecieverUsername = messageRecieverUsername;
    }


    public String getMessageSenderUsername() {
        return messageSenderUsername;
    }

    public void setMessageSenderUsername(String messageSenderUsername) {
        this.messageSenderUsername = messageSenderUsername;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public long getMessageRecieverId() {
        return messageRecieverId;
    }

    public void setMessageRecieverId(long messageRecieverId) {
        this.messageRecieverId = messageRecieverId;
    }

    public long getMessageSenderId() {
        return messageSenderId;
    }

    public void setMessageSenderId(long messageSenderId) {
        this.messageSenderId = messageSenderId;
    }

    public long getMessageReservationId() {
        return messageReservationId;
    }

    public void setMessageReservationId(long messageReservationId) {
        this.messageReservationId = messageReservationId;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}
