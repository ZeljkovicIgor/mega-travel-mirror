
package com.megatravel.mainbackend.ws.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for acc_unavailableSoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acc_unavailableSoap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="unav_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="unavailable_start" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="unavailable_end" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acc_unavailableSoap", namespace = "http://megatravel.com/booking/ws", propOrder = {
    "unavId",
    "unavailableStart",
    "unavailableEnd"
})
public class AccUnavailableSoap {

    @XmlElement(name = "unav_id", namespace = "http://megatravel.com/booking/ws")
    protected long unavId;
    @XmlElement(name = "unavailable_start", namespace = "http://megatravel.com/booking/ws", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date unavailableStart;
    @XmlElement(name = "unavailable_end", namespace = "http://megatravel.com/booking/ws", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date unavailableEnd;

    /**
     * Gets the value of the unavId property.
     * 
     */
    public long getUnavId() {
        return unavId;
    }

    /**
     * Sets the value of the unavId property.
     * 
     */
    public void setUnavId(long value) {
        this.unavId = value;
    }

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
