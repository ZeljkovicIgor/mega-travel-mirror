
package com.megatravel.agentbackend.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

public class Adapter1
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return (com.megatravel.agentbackend.util.MyDatatypeConverter.parseDate(value));
    }

    public String marshal(Date value) {
        return (com.megatravel.agentbackend.util.MyDatatypeConverter.printDate(value));
    }

}
