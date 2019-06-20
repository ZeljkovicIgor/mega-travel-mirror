
package com.megatravel.agentbackend.ws;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for acc_priceSoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acc_priceSoap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="price_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="price_value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="price_start_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="price_end_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acc_priceSoap", propOrder = {
    "priceId",
    "priceValue",
    "priceStartDate",
    "priceEndDate"
})
public class AccPriceSoap {

    @XmlElement(name = "price_id")
    protected long priceId;
    @XmlElement(name = "price_value")
    protected float priceValue;
    @XmlElement(name = "price_start_date", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date priceStartDate;
    @XmlElement(name = "price_end_date", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date priceEndDate;

    /**
     * Gets the value of the priceId property.
     * 
     */
    public long getPriceId() {
        return priceId;
    }

    /**
     * Sets the value of the priceId property.
     * 
     */
    public void setPriceId(long value) {
        this.priceId = value;
    }

    /**
     * Gets the value of the priceValue property.
     * 
     */
    public float getPriceValue() {
        return priceValue;
    }

    /**
     * Sets the value of the priceValue property.
     * 
     */
    public void setPriceValue(float value) {
        this.priceValue = value;
    }

    /**
     * Gets the value of the priceStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPriceStartDate() {
        return priceStartDate;
    }

    /**
     * Sets the value of the priceStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceStartDate(Date value) {
        this.priceStartDate = value;
    }

    /**
     * Gets the value of the priceEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPriceEndDate() {
        return priceEndDate;
    }

    /**
     * Sets the value of the priceEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceEndDate(Date value) {
        this.priceEndDate = value;
    }

}
