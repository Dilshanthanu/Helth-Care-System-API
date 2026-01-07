package com.mycompany.mycw.models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Patient extends Person{
    
    private int patient_Id;
    private String medicalHistory;
    private String currentHealthStatus;

    public Patient(){
        
    }

    public Patient(int patient_Id,
            String medicalHistory,
            String currentHealthStatus,
            int Person_Id, String Name,
            String address,
            String contact_number,
            String e_mail) {
        super(Person_Id, Name, address, contact_number, e_mail);
        this.patient_Id = patient_Id;
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }

    public int getPatient_Id() {
        return patient_Id;
    }

    public void setPatient_Id(int patient_Id) {
        this.patient_Id = patient_Id;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
    
    

    
}
