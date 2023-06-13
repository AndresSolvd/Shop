package com.solvd.sql.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "supplier")
public class Supplier {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "supplierName")
    private String supplierName;

    @XmlElement(name = "taxNumber")
    private String taxNumber;

    @XmlElement(name = "phone")
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supplierName='" + supplierName + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
