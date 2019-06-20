
package com.megatravel.agentbackend.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for message_statusSoap.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="message_statusSoap">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SENT"/>
 *     &lt;enumeration value="RECIEVED"/>
 *     &lt;enumeration value="SEEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "message_statusSoap")
@XmlEnum
public enum MessageStatusSoap {

    SENT,
    RECIEVED,
    SEEN;

    public String value() {
        return name();
    }

    public static MessageStatusSoap fromValue(String v) {
        return valueOf(v);
    }

}
