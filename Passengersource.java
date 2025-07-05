/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LUTS
 */
import java.util.Random;

public class Passengersource {


 
    public Passengersource(Company company) {
        System.out.println("PassengerSource initialized with a Company object.");
    }
        
    /**
     *
     */

    /**
     *
     */
    public static class CompanyTest {
        
    }

    public boolean requestPickup(Company company) {
        Random random = new Random();
        int pickupX = random.nextInt(101); 
        int pickupY = random.nextInt(101); 
        int destX = random.nextInt(101);   
        int destY = random.nextInt(101);   

        Location pickupLocation = new Location(pickupX, pickupY);
        Location destinationLocation = new Location(destX, destY);
        int seatsRequired = random.nextInt(4) + 1; 

        
        Passenger newPassenger = new Passenger("Passenger_" + System.nanoTime(),
                                                pickupLocation,
                                                destinationLocation,
                                                seatsRequired);

        System.out.println("New Passenger Request:");
        System.out.println("  ID: " + newPassenger.getId());
        System.out.println("  Pickup: (" + pickupLocation.getX() + ", " + pickupLocation.getY() + ")");
        System.out.println("  Destination: (" + destinationLocation.getX() + ", " + destinationLocation.getY() + ")");
        System.out.println("  Seats: " + seatsRequired);
        if (company != null) {
            boolean scheduledSuccessfully = random.nextDouble() < 0.7; 
            System.out.println("  Attempting to schedule with Company...");
            if (scheduledSuccessfully) {
                System.out.println("  Scheduling successful for Passenger: " + newPassenger.getId());
                return true;
            } else {
                System.out.println("  Scheduling failed for Passenger: " + newPassenger.getId());
                return false;
            }
           
        } else {
            System.err.println("Error: Company object is null. Cannot schedule pickup.");
            return false;
        }
    }



    public static class Location {
        private final int x;
        private final int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public int getY() { return y; }
    }

    public static class Passenger {
        private final String id;
        private final Location pickup;
        private final Location destination;
        private final int seatsRequired;

        public Passenger(String id, Location pickup, Location destination, int seatsRequired) {
            this.id = id;
            this.pickup = pickup;
            this.destination = destination;
            this.seatsRequired = seatsRequired;
        }

        public String getId() { return id; }
        public Location getPickup() { return pickup; }
        public Location getDestination() { return destination; }
        public int getSeatsRequired() { return seatsRequired; }
    }
}
