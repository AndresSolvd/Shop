package com.solvd.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BigBang {
    private String name;
    private String last_name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BigBang{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", number=" + number +
                '}';
    }
}
