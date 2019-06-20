
package com.megatravel.agentbackend.ws;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

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
