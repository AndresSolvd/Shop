package com.solvd.sql.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "owner")
public class Owner {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "personId")
    private int personId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", personId=" + personId +
                '}';
    }
}
