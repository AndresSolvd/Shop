package com.solvd.sql.builder;

import com.solvd.sql.model.Person;
import com.solvd.sql.model.Shop;
import com.solvd.sql.model.Staff;

public class StaffBuilder {
    private int id;
    private String position;
    private Person person;
    private Shop shop;

    public static StaffBuilder builder() {
        return new StaffBuilder();
    }

    public StaffBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public StaffBuilder withPosition(String position) {
        this.position = position;
        return this;
    }

    public StaffBuilder withPerson(Person person) {
        this.person = person;
        return this;
    }

    public StaffBuilder withShop(Shop shop) {
        this.shop = shop;
        return this;
    }

    public Staff build() {
        Staff staff = new Staff();
        staff.setId(this.id);
        staff.setPosition(this.position);
        staff.setPerson(this.person);
        staff.setShop(this.shop);
        return staff;
    }
}
