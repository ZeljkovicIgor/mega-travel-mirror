
package com.megatravel.agentbackend.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="reservation_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reservation_price" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
        "reservationId",
        "reservationPrice"
})
@XmlRootElement(name = "sendReservationResponse")
public class SendReservationResponse {

    @XmlElement(name = "reservation_id")
    protected long reservationId;
    @XmlElement(name = "reservation_price")
    protected float reservationPrice;

    /**
     * Gets the value of the reservationId property.
     *
     */
    public long getReservationId() {
        return reservationId;
    }

    /**
     * Sets the value of the reservationId property.
     *
     */
    public void setReservationId(long value) {
        this.reservationId = value;
    }

    /**
     * Gets the value of the reservationPrice property.
     *
     */
    public float getReservationPrice() {
        return reservationPrice;
    }

    /**
     * Sets the value of the reservationPrice property.
     *
     */
    public void setReservationPrice(float value) {
        this.reservationPrice = value;
    }

}
