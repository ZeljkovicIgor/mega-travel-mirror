
package com.megatravel.agentbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acc_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acc_type">
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
@XmlType(name = "acc_type", namespace = "http://megatravel.com/booking", propOrder = {
    "accTypeId",
    "accTypeName"
})
@Entity
public class AccType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "acc_type_id", namespace = "http://megatravel.com/booking")
    protected long accTypeId;
    protected long accTypeDbId;
    @XmlElement(name = "acc_type_name", namespace = "http://megatravel.com/booking", required = true)
    protected String accTypeName;

    public long getAccTypeDbId() {
        return accTypeDbId;
    }

    public void setAccTypeDbId(long accTypeDbId) {
        this.accTypeDbId = accTypeDbId;
    }

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
