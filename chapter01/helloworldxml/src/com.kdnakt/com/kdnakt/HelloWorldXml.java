package com.kdnakt;

import javax.xml.bind.*;
import java.io.*;

public class HelloWorldXml {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxb = JAXBContext.newInstance(Messages.class);
        Marshaller marshaller = jaxb.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(new Messages(), writer);
        System.out.println(writer.toString());
    }
}