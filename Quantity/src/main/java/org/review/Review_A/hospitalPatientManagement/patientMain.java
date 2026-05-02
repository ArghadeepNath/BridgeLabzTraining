package org.review.Review_A.hospitalPatientManagement;

import java.util.*;

abstract class Patient {
    int patientId;
    String name;
    int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    abstract void calculateBill();

    public void getPatientDetails() {
        System.out.println("ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

interface IMedicalRecord {
    void addRecord(Patient p);
    void viewRecords();
}

class PatientManager implements IMedicalRecord {
    private List<Patient> records = new ArrayList<>();

    @Override
    public void addRecord(Patient p) {
        records.add(p);
    }

    @Override
    public void viewRecords() {
        for (Patient p : records) {
            p.getPatientDetails();
            p.calculateBill();
            System.out.println("-----");
        }
    }
}

class InPatient extends Patient {
    private String diagnosis;

    InPatient(int patientId, String name, int age, String diagnosis) {
        super(patientId, name, age);
        this.diagnosis = diagnosis;
    }

    @Override
    void calculateBill() {
        System.out.println("Bill: 500");
    }
}

class OutPatient extends Patient {

    OutPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }
    @Override
    void calculateBill() {
        System.out.println("Bill: 1000");
    }
}

public class patientMain {
    public static void main(String[] args) {

        PatientManager pm = new PatientManager();

        Patient p1 = new InPatient(1, "Arghadeep", 22, "Fever");
        Patient p2 = new OutPatient(2, "Rahul", 30);

        pm.addRecord(p1);
        pm.addRecord(p2);

        pm.viewRecords();
    }
}