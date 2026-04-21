package org.review.core_question;


import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        int passangerResponse = 0;
        int dist = 0;
        Scanner sc = new Scanner(System.in);
        int passangerNumber = 0;
        int runANewService = 1;
        int totalPassangers = 0, totalDist = 0;

        while (runANewService == 1) {
            System.out.println("Hello Passenger would you like to get on the bus? (1=yes, 0=no)");
            int would = sc.nextInt();

            if (would == 1) {
                passangerNumber++;
                passangerResponse = 0;
                dist = 0;

                while (passangerResponse != 1) {
                    System.out.println("How much distance is the next stop?");
                    int d = sc.nextInt();
                    dist += d;

                    System.out.println("Would you like to get off? (1=yes, 0=no)");
                    passangerResponse = sc.nextInt();
                }

                System.out.println("Passenger " + passangerNumber +
                        " exited. Total distance travelled: " + dist);

                totalDist += dist;
                totalPassangers++;
            } else {
                System.out.println("Potential passenger did not get on");
            }

            System.out.println("Run another service? (1=yes, 0=no)");
            runANewService = sc.nextInt();
        }

        System.out.println("Today total passenger count: " + totalPassangers);
        System.out.println("Today total distance travelled: " + totalDist);
    }
}