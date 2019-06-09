
package com.megatravel.mainbackend.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acc_typeSoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acc_typeSoap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acc_type_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="acc_type_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acc_typeSoap", namespace = "http://megatravel.com/booking/ws", propOrder = {
    "accTypeId",
    "accTypeName"
})
public class AccTypeSoap {

    @XmlElement(name = "acc_type_id", namespace = "http://megatravel.com/booking/ws")
    protected long accTypeId;
    @XmlElement(name = "acc_type_name", namespace = "http://megatravel.com/booking/ws", required = true)
    protected String accTypeName;

    /**
     * Gets the value of the accTypeId property.
     * 
     */
    public long getAccTypeId() {
        return accTypeId;
    }

    /**
     * Sets the value of the accTypeId property.
     * 
     */
    public void setAccTypeId(long value) {
        this.accTypeId = value;
    }

    /**
     * Gets the value of the accTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccTypeName() {
        return accTypeName;
    }

    /**
     * Sets the value of the accTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccTypeName(String value) {
        this.accTypeName = value;
    }

}
