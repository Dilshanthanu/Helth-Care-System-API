/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mycw.models;


public class MedicalRecord {
    
    private int medicalRecord_Id;
    private Patient patient;
    private String diagnosis;
    private String treatment;

    public MedicalRecord(int medicalRecord_Id, Patient patient, String diagnosis, String treatment) {
        this.medicalRecord_Id = medicalRecord_Id;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public MedicalRecord() {
    }

    public int getMedicalRecord_Id() {
        return medicalRecord_Id;
    }

    public void setMedicalRecord_Id(int medicalRecord_Id) {
        this.medicalRecord_Id = medicalRecord_Id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    
   
}
