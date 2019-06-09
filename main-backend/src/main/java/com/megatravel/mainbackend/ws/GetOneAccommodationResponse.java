
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
 *         &lt;element name="accommodation" type="{http://megatravel.com/booking/ws}accommodationSoap"/>
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
    "accommodation"
})
@XmlRootElement(name = "getOneAccommodationResponse", namespace = "http://megatravel.com/booking/ws")
public class GetOneAccommodationResponse {

    @XmlElement(namespace = "http://megatravel.com/booking/ws", required = true)
    protected AccommodationSoap accommodation;

    /**
     * Gets the value of the accommodation property.
     * 
     * @return
     *     possible object is
     *     {@link AccommodationSoap }
     *     
     */
    public AccommodationSoap getAccommodation() {
        return accommodation;
    }

    /**
     * Sets the value of the accommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccommodationSoap }
     *     
     */
    public void setAccommodation(AccommodationSoap value) {
        this.accommodation = value;
    }

}
