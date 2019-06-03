//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.02 at 11:38:22 PM CEST 
//


package com.megatravel.mainbackend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for review complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="review">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="review_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="review_grade">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="review_comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="review_end_user" type="{http://megatravel.com/booking}user"/>
 *         &lt;element name="review_accommodation" type="{http://megatravel.com/booking}accommodation"/>
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
@XmlType(name = "review", propOrder = {
    "reviewId",
    "reviewGrade",
    "reviewComment",
    "reviewEndUser",
    "reviewAccommodation"
})
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "review_id")
    protected long reviewId;
    @XmlElement(name = "review_grade")
    protected int reviewGrade;
    @XmlElement(name = "review_comment", required = true)
    protected String reviewComment;
    @XmlElement(name = "review_end_user", required = true)
    @ManyToOne
    protected User reviewEndUser;
    @XmlElement(name = "review_accommodation", required = true)
    @ManyToOne
    protected Accommodation reviewAccommodation;
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
     *     {@link User }
     *     
     */
    public User getReviewEndUser() {
        return reviewEndUser;
    }

    /**
     * Sets the value of the reviewEndUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setReviewEndUser(User value) {
        this.reviewEndUser = value;
    }

    /**
     * Gets the value of the reviewAccommodation property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodation }
     *     
     */
    public Accommodation getReviewAccommodation() {
        return reviewAccommodation;
    }

    /**
     * Sets the value of the reviewAccommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodation }
     *     
     */
    public void setReviewAccommodation(Accommodation value) {
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