
package com.megatravel.mainbackend.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for reservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="r_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="r_accommodation" type="{http://megatravel.com/booking}accommodation"/>
 *         &lt;element name="r_price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="r_start_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="r_end_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="r_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="r_people">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="r_end_user" type="{http://megatravel.com/booking}user"/>
 *       &lt;/sequence>
 *       &lt;attribute name="realized" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="cancelled" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", namespace = "http://megatravel.com/booking", propOrder = {
    "rId",
    "rAccommodation",
    "rPrice",
    "rStartDate",
    "rEndDate",
    "rDate",
    "rPeople",
    "rEndUser"
})
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "r_id", namespace = "http://megatravel.com/booking")
    protected long rId;
    @XmlElement(name = "r_accommodation", namespace = "http://megatravel.com/booking", required = true)
    @ManyToOne
    protected Accommodation rAccommodation;
    @XmlElement(name = "r_price", namespace = "http://megatravel.com/booking")
    protected float rPrice;
    @XmlElement(name = "r_start_date", namespace = "http://megatravel.com/booking", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date rStartDate;
    @XmlElement(name = "r_end_date", namespace = "http://megatravel.com/booking", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date rEndDate;
    @XmlElement(name = "r_date", namespace = "http://megatravel.com/booking", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date rDate;
    @XmlElement(name = "r_people", namespace = "http://megatravel.com/booking", required = true)
    protected BigInteger rPeople;
    @XmlElement(name = "r_end_user", namespace = "http://megatravel.com/booking", required = true)
    @ManyToOne
    protected User rEndUser;
    @XmlAttribute(name = "realized")
    protected Boolean realized;
    @XmlAttribute(name = "cancelled")
    protected Boolean cancelled;

    /**
     * Gets the value of the rId property.
     * 
     */
    public long getRId() {
        return rId;
    }

    /**
     * Sets the value of the rId property.
     * 
     */
    public void setRId(long value) {
        this.rId = value;
    }

    /**
     * Gets the value of the rAccommodation property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodation }
     *     
     */
    public Accommodation getRAccommodation() {
        return rAccommodation;
    }

    /**
     * Sets the value of the rAccommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodation }
     *     
     */
    public void setRAccommodation(Accommodation value) {
        this.rAccommodation = value;
    }

    /**
     * Gets the value of the rPrice property.
     * 
     */
    public float getRPrice() {
        return rPrice;
    }

    /**
     * Sets the value of the rPrice property.
     * 
     */
    public void setRPrice(float value) {
        this.rPrice = value;
    }

    /**
     * Gets the value of the rStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getRStartDate() {
        return rStartDate;
    }

    /**
     * Sets the value of the rStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRStartDate(Date value) {
        this.rStartDate = value;
    }

    /**
     * Gets the value of the rEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getREndDate() {
        return rEndDate;
    }

    /**
     * Sets the value of the rEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREndDate(Date value) {
        this.rEndDate = value;
    }

    /**
     * Gets the value of the rDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getRDate() {
        return rDate;
    }

    /**
     * Sets the value of the rDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRDate(Date value) {
        this.rDate = value;
    }

    /**
     * Gets the value of the rPeople property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRPeople() {
        return rPeople;
    }

    /**
     * Sets the value of the rPeople property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRPeople(BigInteger value) {
        this.rPeople = value;
    }

    /**
     * Gets the value of the rEndUser property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getREndUser() {
        return rEndUser;
    }

    /**
     * Sets the value of the rEndUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setREndUser(User value) {
        this.rEndUser = value;
    }

    /**
     * Gets the value of the realized property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRealized() {
        if (realized == null) {
            return false;
        } else {
            return realized;
        }
    }

    /**
     * Sets the value of the realized property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRealized(Boolean value) {
        this.realized = value;
    }

    /**
     * Gets the value of the cancelled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCancelled() {
        if (cancelled == null) {
            return false;
        } else {
            return cancelled;
        }
    }

    /**
     * Sets the value of the cancelled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCancelled(Boolean value) {
        this.cancelled = value;
    }

}
