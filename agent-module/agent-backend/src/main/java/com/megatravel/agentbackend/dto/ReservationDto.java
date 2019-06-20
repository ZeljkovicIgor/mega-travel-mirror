package com.megatravel.agentbackend.dto;

import java.util.Date;

public class ReservationDto {

    private long rId;

    private long rAccommodationId;
    private String rAccommodationName;
    private float rPrice;
    private Date rStartDate;
    private Date rEndDate;
    private Date rDate;
    private int rPeople;
    private long rEndUserId;
    private String rEndUserUsername;
    private Boolean realized;

    private Boolean cancelled;

    public ReservationDto() {
    }

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public long getrAccommodationId() {
        return rAccommodationId;
    }

    public void setrAccommodationId(long rAccommodationId) {
        this.rAccommodationId = rAccommodationId;
    }

    public float getrPrice() {
        return rPrice;
    }

    public void setrPrice(float rPrice) {
        this.rPrice = rPrice;
    }

    public Date getrStartDate() {
        return rStartDate;
    }

    public void setrStartDate(Date rStartDate) {
        this.rStartDate = rStartDate;
    }

    public Date getrEndDate() {
        return rEndDate;
    }

    public void setrEndDate(Date rEndDate) {
        this.rEndDate = rEndDate;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public int getrPeople() {
        return rPeople;
    }

    public void setrPeople(int rPeople) {
        this.rPeople = rPeople;
    }

    public long getrEndUserId() {
        return rEndUserId;
    }

    public void setrEndUserId(long rEndUserId) {
        this.rEndUserId = rEndUserId;
    }

    public Boolean getRealized() {
        return realized;
    }

    public void setRealized(Boolean realized) {
        this.realized = realized;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
