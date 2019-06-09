
package com.megatravel.mainbackend.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for user_typeSoap.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="user_typeSoap">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADMIN"/>
 *     &lt;enumeration value="ENDUSER"/>
 *     &lt;enumeration value="AGENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "user_typeSoap", namespace = "http://megatravel.com/booking/ws")
@XmlEnum
public enum UserTypeSoap {

    ADMIN,
    ENDUSER,
    AGENT;

    public String value() {
        return name();
    }

    public static UserTypeSoap fromValue(String v) {
        return valueOf(v);
    }

}
