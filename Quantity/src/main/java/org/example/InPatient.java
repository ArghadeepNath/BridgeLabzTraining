package org.example;

public class InPatient extends Patient{
    private int roomNumber;
    private int numberOfDays;
    private int dailyCharge;
    public int getNumberOfDays(){
        return numberOfDays;
    }
    public int getDailyCharge(){
        return dailyCharge;
    }
    InPatient(int patientId,String name,int age,int roomNumber,int numberOfDays,int dailyCharge){
        super(patientId,name,age);
        if(numberOfDays<1 || numberOfDays>365) throw new IllegalArgumentException("Number of Days should be between 1 and 365");
        if(dailyCharge<1 || dailyCharge>50000) throw new IllegalArgumentException("Daily Charge should be between 1 and 50000");
        this.roomNumber=roomNumber;
        this.numberOfDays=numberOfDays;
        this.dailyCharge=dailyCharge;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Patient Room Number :"+roomNumber);
        System.out.println("Patient Number of Days :"+numberOfDays);
        System.out.println("Patient Daily Charge :"+dailyCharge);

    }
}
