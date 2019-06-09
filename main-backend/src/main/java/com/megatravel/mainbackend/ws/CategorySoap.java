
package com.megatravel.mainbackend.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for categorySoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="categorySoap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="category_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="category_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categorySoap", namespace = "http://megatravel.com/booking/ws", propOrder = {
    "categoryId",
    "categoryName"
})
public class CategorySoap {

    @XmlElement(name = "category_id", namespace = "http://megatravel.com/booking/ws")
    protected long categoryId;
    @XmlElement(name = "category_name", namespace = "http://megatravel.com/booking/ws", required = true)
    protected String categoryName;

    /**
     * Gets the value of the categoryId property.
     * 
     */
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     * 
     */
    public void setCategoryId(long value) {
        this.categoryId = value;
    }

    /**
     * Gets the value of the categoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the categoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryName(String value) {
        this.categoryName = value;
    }

}
