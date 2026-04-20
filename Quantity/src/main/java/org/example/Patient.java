package org.example;

public class Patient {
    private final int patientId;
    private final String name;
    private final int age;

    Patient(int patientId,String name,int age){
        if(patientId<1 || patientId>100000 ) throw new IllegalArgumentException("Id should be between 1 and 100k");
        if(age<1 || age>120) throw new IllegalArgumentException("Age should be between 1 and 120");
        this.patientId=patientId;
        this.name=name;
        this.age=age;
    }
    public void displayInfo(){
        System.out.println("Patient Id :"+patientId);
        System.out.println("Patient Name :"+name);
        System.out.println("Patient Age :"+age);
    }
}


