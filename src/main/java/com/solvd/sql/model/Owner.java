package com.solvd.sql.model;

public class Owner {
    private int id;
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
