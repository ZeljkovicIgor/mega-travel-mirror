
package com.megatravel.mainbackend.ws.model;

import com.megatravel.mainbackend.ws.messages.AccLocationSoap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for accommodationSoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accommodationSoap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acc_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="acc_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="acc_description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="acc_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="acc_capacity">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="acc_pictures" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded"/>
 *         &lt;element name="acc_price_plan" type="{http://megatravel.com/booking/ws}acc_priceSoap" maxOccurs="unbounded"/>
 *         &lt;element name="acc_unavailable" type="{http://megatravel.com/booking/ws}acc_unavailableSoap"/>
 *         &lt;element name="acc_location" type="{http://megatravel.com/booking/ws}acc_locationSoap"/>
 *         &lt;element name="acc_category" type="{http://megatravel.com/booking/ws}categorySoap"/>
 *         &lt;element name="acc_type" type="{http://megatravel.com/booking/ws}acc_typeSoap"/>
 *         &lt;element name="acc_services" type="{http://megatravel.com/booking/ws}add_serviceSoap" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="acc_agent" type="{http://megatravel.com/booking/ws}userSoap"/>
 *         &lt;element name="acc_cancel_period">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="acc_avg_rating">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accommodationSoap", namespace = "http://megatravel.com/booking/ws", propOrder = {
    "accId",
    "accName",
    "accDescription",
    "accDate",
    "accCapacity",
    "accPictures",
    "accPricePlan",
    "accUnavailable",
    "accLocation",
    "accCategory",
    "accType",
    "accServices",
    "accAgent",
    "accCancelPeriod",
    "accAvgRating"
})
public class AccommodationSoap {

    @XmlElement(name = "acc_id", namespace = "http://megatravel.com/booking/ws")
    protected long accId;
    @XmlElement(name = "acc_name", namespace = "http://megatravel.com/booking/ws", required = true)
    protected String accName;
    @XmlElement(name = "acc_description", namespace = "http://megatravel.com/booking/ws", required = true)
    protected String accDescription;
    @XmlElement(name = "acc_date", namespace = "http://megatravel.com/booking/ws", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date accDate;
    @XmlElement(name = "acc_capacity", namespace = "http://megatravel.com/booking/ws")
    protected int accCapacity;
    @XmlElement(name = "acc_pictures", namespace = "http://megatravel.com/booking/ws", required = true)
    protected List<byte[]> accPictures;
    @XmlElement(name = "acc_price_plan", namespace = "http://megatravel.com/booking/ws", required = true)
    protected List<AccPriceSoap> accPricePlan;
    @XmlElement(name = "acc_unavailable", namespace = "http://megatravel.com/booking/ws")
    protected List<AccUnavailableSoap> accUnavailable;
    @XmlElement(name = "acc_location", namespace = "http://megatravel.com/booking/ws", required = true)
    protected AccLocationSoap accLocation;
    @XmlElement(name = "acc_category", namespace = "http://megatravel.com/booking/ws", required = true)
    protected CategorySoap accCategory;
    @XmlElement(name = "acc_type", namespace = "http://megatravel.com/booking/ws", required = true)
    protected AccTypeSoap accType;
    @XmlElement(name = "acc_services", namespace = "http://megatravel.com/booking/ws")
    protected List<AddServiceSoap> accServices;
    @XmlElement(name = "acc_agent", namespace = "http://megatravel.com/booking/ws", required = true)
    protected UserSoap accAgent;
    @XmlElement(name = "acc_cancel_period", namespace = "http://megatravel.com/booking/ws", required = true)
    protected BigInteger accCancelPeriod;
    @XmlElement(name = "acc_avg_rating", namespace = "http://megatravel.com/booking/ws", defaultValue = "0")
    protected float accAvgRating;

    /**
     * Gets the value of the accId property.
     * 
     */
    public long getAccId() {
        return accId;
    }

    /**
     * Sets the value of the accId property.
     * 
     */
    public void setAccId(long value) {
        this.accId = value;
    }

    /**
     * Gets the value of the accName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccName() {
        return accName;
    }

    /**
     * Sets the value of the accName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccName(String value) {
        this.accName = value;
    }

    /**
     * Gets the value of the accDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccDescription() {
        return accDescription;
    }

    /**
     * Sets the value of the accDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccDescription(String value) {
        this.accDescription = value;
    }

    /**
     * Gets the value of the accDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getAccDate() {
        return accDate;
    }

    /**
     * Sets the value of the accDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccDate(Date value) {
        this.accDate = value;
    }

    /**
     * Gets the value of the accCapacity property.
     * 
     */
    public int getAccCapacity() {
        return accCapacity;
    }

    /**
     * Sets the value of the accCapacity property.
     * 
     */
    public void setAccCapacity(int value) {
        this.accCapacity = value;
    }

    /**
     * Gets the value of the accPictures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accPictures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccPictures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getAccPictures() {
        if (accPictures == null) {
            accPictures = new ArrayList<byte[]>();
        }
        return this.accPictures;
    }

    /**
     * Gets the value of the accPricePlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accPricePlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccPricePlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccPriceSoap }
     * 
     * 
     */
    public List<AccPriceSoap> getAccPricePlan() {
        if (accPricePlan == null) {
            accPricePlan = new ArrayList<AccPriceSoap>();
        }
        return this.accPricePlan;
    }

    public void setAccPricePlan(List<AccPriceSoap> accPricePlan) {
        this.accPricePlan = accPricePlan;
    }

    public void setAccUnavailable(List<AccUnavailableSoap> accUnavailable) {
        this.accUnavailable = accUnavailable;
    }

    public void setAccServices(List<AddServiceSoap> accServices) {
        this.accServices = accServices;
    }

    /**
     * Gets the value of the accUnavailable property.
     * 
     * @return
     *     possible object is
     *     {@link AccUnavailableSoap }
     *     
     */


    /**
     * Sets the value of the accUnavailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccUnavailableSoap }
     *     
     */

    /**
     * Gets the value of the accLocation property.
     * 
     * @return
     *     possible object is
     *     {@link AccLocationSoap }
     *     
     */
    public AccLocationSoap getAccLocation() {
        return accLocation;
    }

    /**
     * Sets the value of the accLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccLocationSoap }
     *     
     */
    public void setAccLocation(AccLocationSoap value) {
        this.accLocation = value;
    }

    /**
     * Gets the value of the accCategory property.
     * 
     * @return
     *     possible object is
     *     {@link CategorySoap }
     *     
     */
    public CategorySoap getAccCategory() {
        return accCategory;
    }

    /**
     * Sets the value of the accCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategorySoap }
     *     
     */
    public void setAccCategory(CategorySoap value) {
        this.accCategory = value;
    }

    /**
     * Gets the value of the accType property.
     * 
     * @return
     *     possible object is
     *     {@link AccTypeSoap }
     *     
     */
    public AccTypeSoap getAccType() {
        return accType;
    }

    /**
     * Sets the value of the accType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccTypeSoap }
     *     
     */
    public void setAccType(AccTypeSoap value) {
        this.accType = value;
    }

    /**
     * Gets the value of the accServices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accServices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddServiceSoap }
     * 
     * 
     */
    public List<AddServiceSoap> getAccServices() {
        if (accServices == null) {
            accServices = new ArrayList<AddServiceSoap>();
        }
        return this.accServices;
    }

    /**
     * Gets the value of the accAgent property.
     * 
     * @return
     *     possible object is
     *     {@link UserSoap }
     *     
     */
    public UserSoap getAccAgent() {
        return accAgent;
    }

    /**
     * Sets the value of the accAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserSoap }
     *     
     */
    public void setAccAgent(UserSoap value) {
        this.accAgent = value;
    }

    /**
     * Gets the value of the accCancelPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAccCancelPeriod() {
        return accCancelPeriod;
    }

    /**
     * Sets the value of the accCancelPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAccCancelPeriod(BigInteger value) {
        this.accCancelPeriod = value;
    }

    /**
     * Gets the value of the accAvgRating property.
     * 
     */
    public float getAccAvgRating() {
        return accAvgRating;
    }

    /**
     * Sets the value of the accAvgRating property.
     * 
     */
    public void setAccAvgRating(float value) {
        this.accAvgRating = value;
    }

}
