package com.telegrambot.models;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String secondName;
    private String tgID;
    public Person(){

    }
    public Person(int id, String firstName, String lastName, String secondName, String tgID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.tgID = tgID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getTgID() {
        return tgID;
    }

    public void setTgID(String tgID) {
        this.tgID = tgID;
    }
}
