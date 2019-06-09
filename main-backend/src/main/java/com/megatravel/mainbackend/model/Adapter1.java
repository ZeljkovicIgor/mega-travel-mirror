
package com.megatravel.mainbackend.model;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

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
