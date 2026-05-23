package org.review.seven;

import java.time.LocalDateTime;
import java.util.*;

class Driver {

    int driverId;
    String driverName;
    String vehicleNumber;
    String vehicleType;
    String currentLocation;
    double rating;
    boolean isAvailable;
    int totalRides;
    double totalEarnings;

    public Driver(int driverId, String driverName, String vehicleNumber, String vehicleType, String currentLocation, double rating) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.currentLocation = currentLocation;
        this.rating = rating;
        this.isAvailable = true;
        this.totalRides = 0;
        this.totalEarnings = 0;
    }

    @Override
    public String toString() {
        return "Driver ID: " + driverId + ", Name: " + driverName + ", Rating: " + rating + ", Available: " + isAvailable + ", Total Rides: " + totalRides + ", Earnings: " + totalEarnings;
    }
}

class Passenger {

    int passengerId;
    String passengerName;
    List<Ride> rideHistory = new ArrayList<>();

    public Passenger(int passengerId, String passengerName) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return "Passenger ID: " + passengerId + ", Name: " + passengerName;
    }
}

class Ride {

    int rideId;
    int driverId;
    int passengerId;
    String pickupLocation;
    String dropLocation;
    double distance;
    double fare;
    String rideStatus;
    LocalDateTime bookingTime;

    public Ride(int rideId, int driverId, int passengerId, String pickupLocation, String dropLocation, double distance, double fare, String rideStatus) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.passengerId = passengerId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distance = distance;
        this.fare = fare;
        this.rideStatus = rideStatus;
        this.bookingTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Ride ID: " + rideId + ", Driver ID: " + driverId + ", Passenger ID: " + passengerId + ", Pickup: " + pickupLocation + ", Drop: " + dropLocation + ", Distance: " + distance + ", Fare: " + fare + ", Status: " + rideStatus;
    }
}

class RideService {

    HashMap<Integer, Driver> drivers = new HashMap<>();
    HashMap<Integer, Passenger> passengers = new HashMap<>();
    HashMap<Integer, Ride> rides = new HashMap<>();

    List<Ride> completedRides = new ArrayList<>();
    List<Ride> cancelledRides = new ArrayList<>();

    TreeMap<Integer, Integer> bookingHours = new TreeMap<>();

    public void addDriver(Driver driver) {
        drivers.put(driver.driverId, driver);
        System.out.println("Driver Added Successfully");
    }

    public void registerPassenger(Passenger passenger) {
        passengers.put(passenger.passengerId, passenger);
        System.out.println("Passenger Registered Successfully");
    }

    public Driver findAvailableDriver() {

        Driver bestDriver = null;

        for (Driver driver : drivers.values()) {

            if (driver.isAvailable) {

                if (bestDriver == null || driver.rating > bestDriver.rating) {
                    bestDriver = driver;
                }
            }
        }

        return bestDriver;
    }

    public void bookRide(int rideId, int passengerId, String pickup, String drop, double distance) {

        Passenger passenger = passengers.get(passengerId);

        if (passenger == null) {
            System.out.println("Passenger Not Found");
            return;
        }

        Driver driver = findAvailableDriver();

        if (driver == null) {
            System.out.println("No Drivers Available");
            return;
        }

        driver.isAvailable = false;

        double fare = calculateFare(distance);

        Ride ride = new Ride(rideId, driver.driverId, passengerId, pickup, drop, distance, fare, "BOOKED");

        rides.put(rideId, ride);

        passenger.rideHistory.add(ride);

        int hour = ride.bookingTime.getHour();

        bookingHours.put(hour, bookingHours.getOrDefault(hour, 0) + 1);

        System.out.println("Ride Booked Successfully");
        System.out.println(ride);
    }

    public void completeRide(int rideId) {

        Ride ride = rides.get(rideId);

        if (ride == null) {
            System.out.println("Ride Not Found");
            return;
        }

        if (ride.rideStatus.equals("COMPLETED")) {
            System.out.println("Ride Already Completed");
            return;
        }

        ride.rideStatus = "COMPLETED";

        Driver driver = drivers.get(ride.driverId);

        driver.isAvailable = true;
        driver.totalRides++;
        driver.totalEarnings += ride.fare;

        completedRides.add(ride);

        System.out.println("Ride Completed Successfully");
    }

    public void cancelRide(int rideId) {

        Ride ride = rides.get(rideId);

        if (ride == null) {
            System.out.println("Ride Not Found");
            return;
        }

        if (ride.rideStatus.equals("COMPLETED")) {
            System.out.println("Completed Ride Cannot Be Cancelled");
            return;
        }

        ride.rideStatus = "CANCELLED";

        Driver driver = drivers.get(ride.driverId);

        driver.isAvailable = true;

        cancelledRides.add(ride);

        System.out.println("Ride Cancelled Successfully");
    }

    public double calculateFare(double distance) {
        return 50 + (distance * 12);
    }

    public void searchDriver(int driverId) {

        Driver driver = drivers.get(driverId);

        if (driver != null) {
            System.out.println(driver);
        } else {
            System.out.println("Driver Not Found");
        }
    }

    public void searchPassenger(int passengerId) {

        Passenger passenger = passengers.get(passengerId);

        if (passenger != null) {
            System.out.println(passenger);
        } else {
            System.out.println("Passenger Not Found");
        }
    }

    public void searchRide(int rideId) {

        Ride ride = rides.get(rideId);

        if (ride != null) {
            System.out.println(ride);
        } else {
            System.out.println("Ride Not Found");
        }
    }

    public void sortDriversByRating() {

        List<Driver> driverList = new ArrayList<>(drivers.values());

        driverList.sort((a, b) -> Double.compare(b.rating, a.rating));

        for (Driver driver : driverList) {
            System.out.println(driver);
        }
    }

    public void sortDriversByTotalRides() {

        List<Driver> driverList = new ArrayList<>(drivers.values());

        driverList.sort((a, b) -> b.totalRides - a.totalRides);

        for (Driver driver : driverList) {
            System.out.println(driver);
        }
    }

    public void sortRidesByFare() {

        List<Ride> rideList = new ArrayList<>(rides.values());

        rideList.sort((a, b) -> Double.compare(b.fare, a.fare));

        for (Ride ride : rideList) {
            System.out.println(ride);
        }
    }

    public void sortRidesByDistance() {

        List<Ride> rideList = new ArrayList<>(rides.values());

        rideList.sort((a, b) -> Double.compare(b.distance, a.distance));

        for (Ride ride : rideList) {
            System.out.println(ride);
        }
    }

    public void showPassengerRideHistory(int passengerId) {

        Passenger passenger = passengers.get(passengerId);

        if (passenger == null) {
            System.out.println("Passenger Not Found");
            return;
        }

        for (Ride ride : passenger.rideHistory) {
            System.out.println(ride);
        }
    }

    public void showDriverCompletedRides(int driverId) {

        for (Ride ride : completedRides) {

            if (ride.driverId == driverId) {
                System.out.println(ride);
            }
        }
    }

    public void generateAnalytics() {

        Driver topDriver = null;

        for (Driver driver : drivers.values()) {

            if (topDriver == null || driver.totalEarnings > topDriver.totalEarnings) {
                topDriver = driver;
            }
        }

        if (topDriver != null) {
            System.out.println("Highest Earning Driver: " + topDriver);
        }

        Passenger activePassenger = null;

        for (Passenger passenger : passengers.values()) {

            if (activePassenger == null || passenger.rideHistory.size() > activePassenger.rideHistory.size()) {
                activePassenger = passenger;
            }
        }

        if (activePassenger != null) {
            System.out.println("Most Active Passenger: " + activePassenger);
        }

        System.out.println("Total Completed Rides: " + completedRides.size());

        System.out.println("Total Cancelled Rides: " + cancelledRides.size());

        int peakHour = -1;
        int maxBookings = 0;

        for (Map.Entry<Integer, Integer> entry : bookingHours.entrySet()) {

            if (entry.getValue() > maxBookings) {
                maxBookings = entry.getValue();
                peakHour = entry.getKey();
            }
        }

        System.out.println("Peak Booking Hour: " + peakHour + ":00");
    }
}

public class RideManagementSystem {

    public static void main(String[] args) {

        RideService service = new RideService();

        service.addDriver(new Driver(1, "Rahul", "PB10AA1111", "Sedan", "Mohali", 4.8));
        service.addDriver(new Driver(2, "Aman", "PB10BB2222", "SUV", "Chandigarh", 4.5));
        service.addDriver(new Driver(3, "Karan", "PB10CC3333", "Mini", "Zirakpur", 4.9));

        service.registerPassenger(new Passenger(101, "Arghadeep"));
        service.registerPassenger(new Passenger(102, "Rohan"));

        service.bookRide(1001, 101, "Sector 17", "Airport", 12);
        service.bookRide(1002, 102, "ISBT", "Elante Mall", 8);

        service.completeRide(1001);

        service.cancelRide(1002);

        service.searchDriver(1);
        service.searchPassenger(101);
        service.searchRide(1001);

        service.sortDriversByRating();
        service.sortDriversByTotalRides();

        service.sortRidesByFare();
        service.sortRidesByDistance();

        service.showPassengerRideHistory(101);

        service.showDriverCompletedRides(3);

        service.generateAnalytics();
    }
}