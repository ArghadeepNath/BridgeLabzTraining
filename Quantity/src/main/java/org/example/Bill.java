package org.example;

public class Bill implements IPayable {

    private Patient patient;

    public Bill(Patient patient) {
        this.patient = patient;
    }

    @Override
    public int CalculateBill() {

        if (patient instanceof InPatient) {
            InPatient ip = (InPatient) patient;
            return ip.getNumberOfDays() * ip.getDailyCharge();
        }

        else if (patient instanceof OutPatient op) {
            return op.getDoctorFee();
        }

        return 0;
    }
}