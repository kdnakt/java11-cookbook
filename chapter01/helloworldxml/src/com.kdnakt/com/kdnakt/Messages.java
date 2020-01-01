package com.kdnakt;

// import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Messages {
    @XmlElement
    public final String message = "Hello World in XML";
}