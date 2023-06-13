package com.solvd.sql.model;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "owner")
@JsonRootName(value = "owner")
public class Owner {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "personId")
    @JsonProperty("personId")
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