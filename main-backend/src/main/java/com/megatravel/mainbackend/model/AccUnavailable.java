//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.02 at 11:38:22 PM CEST 
//


package com.megatravel.mainbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;


/**
 * <p>Java class for acc_unavailable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acc_unavailable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="unavailable_start" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="unavailable_end" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acc_unavailable", propOrder = {
    "unavailableStart",
    "unavailableEnd"
})
@Entity
public class AccUnavailable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "un_id")
    protected long unId;
    @XmlElement(name = "unavailable_start", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date unavailableStart;
    @XmlElement(name = "unavailable_end", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date unavailableEnd;

    /**
     * Gets the value of the unavailableStart property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public Long getUnId() {
        return unId;
    }

    /**
     * Sets the value of the unId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnId(Long value) {
        this.unId = value;
    }

    /**
     * Gets the value of the unavailableEnd property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    /**
     * Gets the value of the unavailableStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getUnavailableStart() {
        return unavailableStart;
    }

    /**
     * Sets the value of the unavailableStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnavailableStart(Date value) {
        this.unavailableStart = value;
    }

    /**
     * Gets the value of the unavailableEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getUnavailableEnd() {
        return unavailableEnd;
    }

    /**
     * Sets the value of the unavailableEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnavailableEnd(Date value) {
        this.unavailableEnd = value;
    }

}
