
package com.megatravel.mainbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for accommodation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accommodation">
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
 *         &lt;element name="acc_price_plan" type="{http://megatravel.com/booking}acc_price" maxOccurs="unbounded"/>
 *         &lt;element name="acc_unavailable" type="{http://megatravel.com/booking}acc_unavailable"/>
 *         &lt;element name="acc_location" type="{http://megatravel.com/booking}acc_location"/>
 *         &lt;element name="acc_category" type="{http://megatravel.com/booking}category"/>
 *         &lt;element name="acc_type" type="{http://megatravel.com/booking}acc_type"/>
 *         &lt;element name="acc_services" type="{http://megatravel.com/booking}add_service" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="acc_agent" type="{http://megatravel.com/booking}user"/>
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
@XmlType(name = "accommodation", namespace = "http://megatravel.com/booking", propOrder = {
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
@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "acc_id", namespace = "http://megatravel.com/booking")
    protected long accId;
    @XmlElement(name = "acc_name", namespace = "http://megatravel.com/booking", required = true)
    protected String accName;
    @XmlElement(name = "acc_description", namespace = "http://megatravel.com/booking", required = true)
    protected String accDescription;
    @XmlElement(name = "acc_date", namespace = "http://megatravel.com/booking", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date accDate;
    @XmlElement(name = "acc_capacity", namespace = "http://megatravel.com/booking")
    protected int accCapacity;
    @XmlElement(name = "acc_pictures", namespace = "http://megatravel.com/booking", required = true)
    @Lob
    protected List<byte[]> accPictures;
    @XmlElement(name = "acc_price_plan", namespace = "http://megatravel.com/booking", required = true)
    @OneToMany(cascade = CascadeType.ALL)
    protected List<AccPrice> accPricePlan;
    @XmlElement(name = "acc_unavailable", namespace = "http://megatravel.com/booking")
    @OneToMany(cascade = CascadeType.ALL)
    protected List<AccUnavailable> accUnavailable;
    @ManyToOne
    @XmlElement(name = "acc_location", namespace = "http://megatravel.com/booking", required = true)
    protected AccLocation accLocation;
    @XmlElement(name = "acc_category", namespace = "http://megatravel.com/booking", required = true)
    @ManyToOne
    protected Category accCategory;
    @XmlElement(name = "acc_type", namespace = "http://megatravel.com/booking", required = true)
    @ManyToOne
    protected AccType accType;
    @XmlElement(name = "acc_services", namespace = "http://megatravel.com/booking")
    @ManyToMany
    @JoinTable(
            name="accommodation_service",
            joinColumns = @JoinColumn(
                    name="accId"),
            inverseJoinColumns = @JoinColumn(
                    name="serviceId"
            )
    )
    protected List<AddService> accServices;
    @XmlElement(name = "acc_agent", namespace = "http://megatravel.com/booking", required = true)
    @ManyToOne
    protected User accAgent;
    @XmlElement(name = "acc_cancel_period", namespace = "http://megatravel.com/booking", required = true)
    protected int accCancelPeriod;
    @XmlElement(name = "acc_avg_rating", namespace = "http://megatravel.com/booking", defaultValue = "0")
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

    public void setAccPictures(List<byte[]> accPictures) {
        this.accPictures = accPictures;
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
     * {@link AccPrice }
     * 
     * 
     */
    public List<AccPrice> getAccPricePlan() {
        if (accPricePlan == null) {
            accPricePlan = new ArrayList<AccPrice>();
        }
        return this.accPricePlan;
    }

    public void setAccPricePlan(List<AccPrice> accPricePlan) {
        this.accPricePlan = accPricePlan;
    }

    /**
     * Gets the value of the accUnavailable property.
     * 
     * @return
     *     possible object is
     *     {@link AccUnavailable }
     *     
     */
    public List<AccUnavailable> getAccUnavailable() {
        if (accUnavailable == null) {
            accUnavailable = new ArrayList<AccUnavailable>();
        }
        return this.accUnavailable;
    }
    /**
     * Sets the value of the accUnavailable property.
     *
     * @param value
     *     allowed object is
     *     {@link AccUnavailable }
     *
     */
    public void setAccUnavailable(List<AccUnavailable> value) {
        this.accUnavailable = value;
    }


    /**
     * Gets the value of the accLocation property.
     * 
     * @return
     *     possible object is
     *     {@link AccLocation }
     *     
     */
    public AccLocation getAccLocation() {
        return accLocation;
    }

    /**
     * Sets the value of the accLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccLocation }
     *     
     */
    public void setAccLocation(AccLocation value) {
        this.accLocation = value;
    }

    /**
     * Gets the value of the accCategory property.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getAccCategory() {
        return accCategory;
    }

    /**
     * Sets the value of the accCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setAccCategory(Category value) {
        this.accCategory = value;
    }

    /**
     * Gets the value of the accType property.
     * 
     * @return
     *     possible object is
     *     {@link AccType }
     *     
     */
    public AccType getAccType() {
        return accType;
    }

    /**
     * Sets the value of the accType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccType }
     *     
     */
    public void setAccType(AccType value) {
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
     * {@link AddService }
     * 
     * 
     */
    public List<AddService> getAccServices() {
        if (accServices == null) {
            accServices = new ArrayList<AddService>();
        }
        return this.accServices;
    }
    public void setAccServices(List<AddService> accServices) {
        this.accServices = accServices;
    }
    /**
     * Gets the value of the accAgent property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getAccAgent() {
        return accAgent;
    }

    /**
     * Sets the value of the accAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setAccAgent(User value) {
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
    public int getAccCancelPeriod() {
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
    public void setAccCancelPeriod(int value) {
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
