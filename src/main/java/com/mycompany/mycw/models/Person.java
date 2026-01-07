/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mycw.models;

public class Person {

    private int Person_Id;
    private String Name;
    private String address;
    private String contact_number;
    private String e_mail;

    public Person() {

    }

    public Person(int Person_Id, String Name, String address, String contact_number, String e_mail) {
        this.Person_Id = Person_Id;
        this.Name = Name;
        this.address = address;
        this.contact_number = contact_number;
        this.e_mail = e_mail;
    }

    public int getPerson_Id() {
        return Person_Id;
    }

    public void setPerson_Id(int Person_Id) {
        this.Person_Id = Person_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

}
