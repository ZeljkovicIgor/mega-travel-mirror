
package com.megatravel.agentbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acc_location complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acc_location">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loc_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="x_coordinate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="y_coordinate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acc_location", namespace = "http://megatravel.com/booking", propOrder = {
    "locId",
    "address",
    "city",
    "country",
    "xCoordinate",
    "yCoordinate"
})
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class AccLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "loc_id", namespace = "http://megatravel.com/booking")
    protected long locId;
    protected long locDbId;
    @XmlElement(namespace = "http://megatravel.com/booking", required = true)
    protected String address;
    @XmlElement(namespace = "http://megatravel.com/booking", required = true)
    protected String city;
    @XmlElement(namespace = "http://megatravel.com/booking", required = true)
    protected String country;
    @XmlElement(name = "x_coordinate", namespace = "http://megatravel.com/booking")
    protected float xCoordinate;
    @XmlElement(name = "y_coordinate", namespace = "http://megatravel.com/booking")
    protected float yCoordinate;

    public long getLocDbId() {
        return locDbId;
    }

    public void setLocDbId(long locDbId) {
        this.locDbId = locDbId;
    }

    public float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Gets the value of the locId property.
     * 
     */
    public long getLocId() {
        return locId;
    }

    /**
     * Sets the value of the locId property.
     * 
     */
    public void setLocId(long value) {
        this.locId = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the xCoordinate property.
     * 
     */
    public float getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Sets the value of the xCoordinate property.
     * 
     */
    public void setXCoordinate(float value) {
        this.xCoordinate = value;
    }

    /**
     * Gets the value of the yCoordinate property.
     * 
     */
    public float getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Sets the value of the yCoordinate property.
     * 
     */
    public void setYCoordinate(float value) {
        this.yCoordinate = value;
    }

}
