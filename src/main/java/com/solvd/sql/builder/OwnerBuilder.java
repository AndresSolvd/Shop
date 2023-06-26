package com.solvd.sql.builder;

import com.solvd.sql.model.Owner;
import com.solvd.sql.model.Person;

public class OwnerBuilder {
    private int id;
    private Person person;

    public static OwnerBuilder builder() {
        return new OwnerBuilder();
    }

    public OwnerBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public OwnerBuilder withPerson(Person person) {
        this.person = person;
        return this;
    }

    public Owner build() {
        Owner owner = new Owner();
        owner.setId(this.id);
        owner.setPerson(this.person);
        return owner;
    }
}
