/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mycw.models;


public class Billing {
    
    private int billing_Id;
    private Patient patient;
    private Doctor doctor;
    private double amount;
    private boolean paid;

    public Billing() {

    }

    public Billing(int billing_Id , Patient patient, Doctor doctor, double amount, boolean paid) {
        this.billing_Id = billing_Id;
        this.patient = patient;
        this.doctor = doctor;
        this.amount = amount;
        this.paid = paid;
    }

     public int getbilling_Id(){
        return billing_Id;
    }
    public void setbilling_Id(int billing_Id){
        this.billing_Id = billing_Id;
    }
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
}
