
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
 *         &lt;element name="accDB_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "accDBId"
})
@XmlRootElement(name = "addAccommodationsResponse")
public class AddAccommodationsResponse {

    @XmlElement(name = "accDB_id")
    protected long accDBId;

    /**
     * Gets the value of the accDBId property.
     * 
     */
    public long getAccDBId() {
        return accDBId;
    }

    /**
     * Sets the value of the accDBId property.
     * 
     */
    public void setAccDBId(long value) {
        this.accDBId = value;
    }

}
