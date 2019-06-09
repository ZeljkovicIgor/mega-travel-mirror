
package com.megatravel.mainbackend.ws;

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
 *         &lt;element name="acc_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "accId",
    "userId"
})
@XmlRootElement(name = "getOneAccommodationRequest", namespace = "http://megatravel.com/booking/ws")
public class GetOneAccommodationRequest {

    @XmlElement(name = "acc_id", namespace = "http://megatravel.com/booking/ws")
    protected long accId;
    @XmlElement(name = "user_id", namespace = "http://megatravel.com/booking/ws")
    protected long userId;

    /**
     * Gets the value of the accId property.
     * 
     */
    public long getAccId() {
        return accId;
    }

    /**
     * Sets the value of the accId property.
     * 
     */
    public void setAccId(long value) {
        this.accId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

}
