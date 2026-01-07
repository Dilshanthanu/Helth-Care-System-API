/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mycw.models;


public class Doctor extends Person {

    private int Doctor_Id;
    private String specialization;
    
    
    public Doctor(){
        
    }

    public Doctor(int Doctor_Id,
            String specialization, 
            int Person_Id, 
            String Name,
            String address,
            String contact_number,
            String e_mail) {
        super(Person_Id, Name, address, contact_number, e_mail);
        this.Doctor_Id = Doctor_Id;
        this.specialization = specialization;
    }

    public int getDoctor_Id() {
        return Doctor_Id;
    }

    public void setDoctor_Id(int Doctor_Id) {
        this.Doctor_Id = Doctor_Id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}
