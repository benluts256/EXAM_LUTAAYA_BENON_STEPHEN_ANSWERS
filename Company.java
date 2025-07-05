/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LUTS
 */

public class Company {
    private boolean alwaysSucceedsScheduling; 

    /**
     *
     */
    public Company() {
        this.alwaysSucceedsScheduling = false; 
    }

   
    public boolean scheduleVehicle(Passengersource.Passenger passenger) {
      
        System.out.println("Company attempting to schedule vehicle for Passenger: " + passenger.getId());
        if (alwaysSucceedsScheduling) {
            return true;
        } else {
           
            return passenger.getSeatsRequired() <= 5; 
        }
    }

    public void setAlwaysSucceedsScheduling(boolean alwaysSucceedsScheduling) {
        this.alwaysSucceedsScheduling = alwaysSucceedsScheduling;
    }
}
