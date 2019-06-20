
package com.megatravel.agentbackend.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userSoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userSoap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="user_username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_business_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_business_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="user_type" type="{http://megatravel.com/booking/ws}user_typeSoap"/>
 *       &lt;/sequence>
 *       &lt;attribute name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="activated" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userSoap", propOrder = {
    "userId",
    "userUsername",
    "userFirstName",
    "userLastName",
    "userPassword",
    "userEmail",
    "userBusinessId",
    "userBusinessName",
    "userType"
})
public class UserSoap {

    @XmlElement(name = "user_id")
    protected long userId;
    @XmlElement(name = "user_username", required = true)
    protected String userUsername;
    @XmlElement(name = "user_first_name", required = true)
    protected String userFirstName;
    @XmlElement(name = "user_last_name", required = true)
    protected String userLastName;
    @XmlElement(name = "user_password", required = true)
    protected String userPassword;
    @XmlElement(name = "user_email", required = true)
    protected String userEmail;
    @XmlElement(name = "user_business_id", required = true)
    protected String userBusinessId;
    @XmlElement(name = "user_business_name", required = true)
    protected String userBusinessName;
    @XmlElement(name = "user_type", required = true)
    @XmlSchemaType(name = "string")
    protected UserTypeSoap userType;
    @XmlAttribute(name = "deleted")
    protected Boolean deleted;
    @XmlAttribute(name = "activated")
    protected Boolean activated;

    /**
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the userUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserUsername() {
        return userUsername;
    }

    /**
     * Sets the value of the userUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserUsername(String value) {
        this.userUsername = value;
    }

    /**
     * Gets the value of the userFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * Sets the value of the userFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserFirstName(String value) {
        this.userFirstName = value;
    }

    /**
     * Gets the value of the userLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * Sets the value of the userLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLastName(String value) {
        this.userLastName = value;
    }

    /**
     * Gets the value of the userPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the value of the userPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

    /**
     * Gets the value of the userEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the value of the userEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserEmail(String value) {
        this.userEmail = value;
    }

    /**
     * Gets the value of the userBusinessId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserBusinessId() {
        return userBusinessId;
    }

    /**
     * Sets the value of the userBusinessId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserBusinessId(String value) {
        this.userBusinessId = value;
    }

    /**
     * Gets the value of the userBusinessName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserBusinessName() {
        return userBusinessName;
    }

    /**
     * Sets the value of the userBusinessName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserBusinessName(String value) {
        this.userBusinessName = value;
    }

    /**
     * Gets the value of the userType property.
     * 
     * @return
     *     possible object is
     *     {@link UserTypeSoap }
     *     
     */
    public UserTypeSoap getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTypeSoap }
     *     
     */
    public void setUserType(UserTypeSoap value) {
        this.userType = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDeleted() {
        if (deleted == null) {
            return false;
        } else {
            return deleted;
        }
    }

    /**
     * Sets the value of the deleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleted(Boolean value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the activated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isActivated() {
        if (activated == null) {
            return true;
        } else {
            return activated;
        }
    }

    /**
     * Sets the value of the activated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActivated(Boolean value) {
        this.activated = value;
    }

}
