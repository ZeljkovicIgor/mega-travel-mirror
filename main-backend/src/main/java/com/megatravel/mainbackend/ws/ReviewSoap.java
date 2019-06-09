
package com.megatravel.mainbackend.ws;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for reviewSoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reviewSoap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="review_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="acc_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="review_grade">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="review_comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="review_end_user" type="{http://megatravel.com/booking/ws}userSoap"/>
 *         &lt;element name="review_accommodation" type="{http://megatravel.com/booking/ws}accommodationSoap"/>
 *       &lt;/sequence>
 *       &lt;attribute name="comment_approved" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reviewSoap", namespace = "http://megatravel.com/booking/ws", propOrder = {
    "reviewId",
    "accDate",
    "reviewGrade",
    "reviewComment",
    "reviewEndUser",
    "reviewAccommodation"
})
public class ReviewSoap {

    @XmlElement(name = "review_id", namespace = "http://megatravel.com/booking/ws")
    protected long reviewId;
    @XmlElement(name = "acc_date", namespace = "http://megatravel.com/booking/ws", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date accDate;
    @XmlElement(name = "review_grade", namespace = "http://megatravel.com/booking/ws")
    protected int reviewGrade;
    @XmlElement(name = "review_comment", namespace = "http://megatravel.com/booking/ws", required = true)
    protected String reviewComment;
    @XmlElement(name = "review_end_user", namespace = "http://megatravel.com/booking/ws", required = true)
    protected UserSoap reviewEndUser;
    @XmlElement(name = "review_accommodation", namespace = "http://megatravel.com/booking/ws", required = true)
    protected AccommodationSoap reviewAccommodation;
    @XmlAttribute(name = "comment_approved")
    protected Boolean commentApproved;

    /**
     * Gets the value of the reviewId property.
     * 
     */
    public long getReviewId() {
        return reviewId;
    }

    /**
     * Sets the value of the reviewId property.
     * 
     */
    public void setReviewId(long value) {
        this.reviewId = value;
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
     * Gets the value of the reviewGrade property.
     * 
     */
    public int getReviewGrade() {
        return reviewGrade;
    }

    /**
     * Sets the value of the reviewGrade property.
     * 
     */
    public void setReviewGrade(int value) {
        this.reviewGrade = value;
    }

    /**
     * Gets the value of the reviewComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewComment() {
        return reviewComment;
    }

    /**
     * Sets the value of the reviewComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewComment(String value) {
        this.reviewComment = value;
    }

    /**
     * Gets the value of the reviewEndUser property.
     * 
     * @return
     *     possible object is
     *     {@link UserSoap }
     *     
     */
    public UserSoap getReviewEndUser() {
        return reviewEndUser;
    }

    /**
     * Sets the value of the reviewEndUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserSoap }
     *     
     */
    public void setReviewEndUser(UserSoap value) {
        this.reviewEndUser = value;
    }

    /**
     * Gets the value of the reviewAccommodation property.
     * 
     * @return
     *     possible object is
     *     {@link AccommodationSoap }
     *     
     */
    public AccommodationSoap getReviewAccommodation() {
        return reviewAccommodation;
    }

    /**
     * Sets the value of the reviewAccommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccommodationSoap }
     *     
     */
    public void setReviewAccommodation(AccommodationSoap value) {
        this.reviewAccommodation = value;
    }

    /**
     * Gets the value of the commentApproved property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCommentApproved() {
        if (commentApproved == null) {
            return false;
        } else {
            return commentApproved;
        }
    }

    /**
     * Sets the value of the commentApproved property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCommentApproved(Boolean value) {
        this.commentApproved = value;
    }

}
