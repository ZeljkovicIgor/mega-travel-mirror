
package com.megatravel.mainbackend.ws.messages;

import com.megatravel.mainbackend.ws.model.AccTypeSoap;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="acc_type" type="{http://megatravel.com/booking/ws}acc_typeSoap" maxOccurs="unbounded"/>
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
    "accType"
})
@XmlRootElement(name = "getAccTypeResponse", namespace = "http://megatravel.com/booking/ws")
public class GetAccTypeResponse {

    @XmlElement(name = "acc_type", namespace = "http://megatravel.com/booking/ws", required = true)
    protected List<AccTypeSoap> accType;

    /**
     * Gets the value of the accType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccTypeSoap }
     * 
     * 
     */
    public List<AccTypeSoap> getAccType() {
        if (accType == null) {
            accType = new ArrayList<AccTypeSoap>();
        }
        return this.accType;
    }

}
