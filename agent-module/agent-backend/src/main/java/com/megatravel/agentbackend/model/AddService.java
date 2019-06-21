
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
 * <p>Java class for add_service complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="add_service">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="service_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="service_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add_service", namespace = "http://megatravel.com/booking", propOrder = {
    "serviceId",
    "serviceName"
})
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AddService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "service_id", namespace = "http://megatravel.com/booking")
    protected long serviceId;
    protected long serviceDbId;
    @XmlElement(name = "service_name", namespace = "http://megatravel.com/booking", required = true)
    protected String serviceName;

    public long getServiceDbId() {
        return serviceDbId;
    }

    public void setServiceDbId(long serviceDbId) {
        this.serviceDbId = serviceDbId;
    }

    /**
     * Gets the value of the serviceId property.
     * 
     */
    public long getServiceId() {
        return serviceId;
    }

    /**
     * Sets the value of the serviceId property.
     * 
     */
    public void setServiceId(long value) {
        this.serviceId = value;
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

}
