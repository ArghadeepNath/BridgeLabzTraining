package org.example;

public class OutPatient extends Patient{
    private int doctorFee;
    public int getDoctorFee(){
        return doctorFee;
    }
    OutPatient(int patientId,String name,int age,int doctorFee){
        super(patientId,name,age);
        if(doctorFee<1 || doctorFee>50000) throw new IllegalArgumentException("Doctor Fee should be between 1 and 20000");

        this.doctorFee=doctorFee;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Patient Doctor Fee :"+doctorFee);

    }

}
