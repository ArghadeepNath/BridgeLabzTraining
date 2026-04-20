package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Patient Type (1-InPatient, 2-OutPatient)");
        int type = sc.nextInt();

        System.out.println("Id");
        int id = sc.nextInt();

        System.out.println("Name");
        String name = sc.next();

        System.out.println("Age");
        int age = sc.nextInt();

        Patient p = null;

        if (type == 1) {
            System.out.println("Room Number");
            int roomNumber = sc.nextInt();

            System.out.println("Number of Days");
            int days = sc.nextInt();

            System.out.println("Daily Charge");
            int charge = sc.nextInt();

            p = new InPatient(id, name, age, roomNumber, days, charge);
        }

        else if (type == 2) {
            System.out.println("Doctor Fee");
            int fee = sc.nextInt();

            p = new OutPatient(id, name, age, fee);
        }

        System.out.println("--- Patient Details ---");
        p.displayInfo();

        Bill b = new Bill(p);

        System.out.println("--- Bill Details ---");
        System.out.println("Total Bill: ₹" + (int) b.CalculateBill());

        sc.close();
    }
}