package com.solvd.sql.model;

public class Customer {
    private int id;
    private String taxNumber;
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
