
package com.megatravel.mainbackend.ws.messages;

import com.megatravel.mainbackend.model.Reservation;
import com.megatravel.mainbackend.ws.model.ReservationSoap;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reservation" type="{http://megatravel.com/booking/ws}reservationSoap"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reservation"
})
@XmlRootElement(name = "createReservationRequest", namespace = "http://megatravel.com/booking/ws")
public class CreateReservationRequest {

    @XmlElement(namespace = "http://megatravel.com/booking/ws", required = true)
    protected Reservation reservation;

    /**
     * Gets the value of the reservation property.
     * 
     * @return
     *     possible object is
     *     {@link ReservationSoap }
     *     
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Sets the value of the reservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReservationSoap }
     *     
     */
    public void setReservation(Reservation value) {
        this.reservation = value;
    }

}
