//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.02 at 11:38:22 PM CEST 
//


package com.megatravel.mainbackend.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

public class Adapter1
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return (com.megatravel.mainbackend.util.MyDatatypeConverter.parseDate(value));
    }

    public String marshal(Date value) {
        return (com.megatravel.mainbackend.util.MyDatatypeConverter.printDate(value));
    }

}