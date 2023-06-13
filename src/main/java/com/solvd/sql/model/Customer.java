package com.solvd.sql.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class Customer {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "taxNumber")
    private String taxNumber;

    @XmlElement(name = "personId")
    private int personId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", taxNumber='" + taxNumber + '\'' +
                ", personId=" + personId +
                '}';
    }
}
