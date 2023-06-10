package com.solvd.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Test {
    public static void main(String[] args) {

        BigBang bigBang = new BigBang();
        bigBang.setName("lola");
        bigBang.setLast_name("pistolas");
        bigBang.setNumber(4535165);

        System.out.println(bigBang);

        marshall(bigBang);

        marshall(bigBang);
        unmarshall();

    }

    public static void marshall(BigBang bigBang) {
        try{
            JAXBContext context = JAXBContext.newInstance(BigBang.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(bigBang, new File("src/main/resources/test1.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static BigBang unmarshall() {
        BigBang bigBang;
        try {
            JAXBContext context = JAXBContext.newInstance(BigBang.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            bigBang = (BigBang) unmarshaller.unmarshal(new File("src/main/resources/test1.xml"));
            System.out.println(bigBang);
            return bigBang;

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
