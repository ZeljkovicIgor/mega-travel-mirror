
package com.megatravel.mainbackend.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for message_status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="message_status">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SENT"/>
 *     &lt;enumeration value="RECIEVED"/>
 *     &lt;enumeration value="SEEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "message_status", namespace = "http://megatravel.com/booking/ws")
@XmlEnum
public enum MessageStatus {

    SENT,
    RECIEVED,
    SEEN;

    public String value() {
        return name();
    }

    public static MessageStatus fromValue(String v) {
        return valueOf(v);
    }

}
