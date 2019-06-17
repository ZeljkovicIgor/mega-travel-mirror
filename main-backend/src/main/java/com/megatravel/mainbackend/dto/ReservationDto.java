package com.megatravel.mainbackend.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.model.Adapter1;
import com.megatravel.mainbackend.model.User;

public class ReservationDto {

	public long rId;
    public Accommodation rAccommodation;

    public float rPrice;
   
    public Date rStartDate;
   
    public Date rEndDate;

    public Date rDate;
  
    public BigInteger rPeople;
   
    public User rEndUser;

    public Boolean realized;

    public Boolean cancelled;

	public ReservationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getrId() {
		return rId;
	}

	public void setrId(long rId) {
		this.rId = rId;
	}

	public Accommodation getrAccommodation() {
		return rAccommodation;
	}

	public void setrAccommodation(Accommodation rAccommodation) {
		this.rAccommodation = rAccommodation;
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

	public BigInteger getrPeople() {
		return rPeople;
	}

	public void setrPeople(BigInteger rPeople) {
		this.rPeople = rPeople;
	}

	public User getrEndUser() {
		return rEndUser;
	}

	public void setrEndUser(User rEndUser) {
		this.rEndUser = rEndUser;
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
