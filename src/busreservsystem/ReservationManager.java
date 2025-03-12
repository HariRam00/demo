package busreservsystem;

import java.util.ArrayList;
import java.util.List;

class ReservationManager {
    private final List<Bus> buses = new ArrayList<>();
    private final List<Passenger> passengers = new ArrayList<>();

    public void addBus(int busNumber, String type, int capacity, double fare, String pickup, String drop, String arrivalTime) {
        buses.add(new Bus(busNumber, type, capacity, fare, pickup, drop, arrivalTime));
    }

    public void viewBuses() {
        if (buses.isEmpty()) {
            System.out.println("No buses available!");
            return;
        }
        System.out.println("\nAvailable Buses:");
        for (Bus b : buses) {
            b.displayBusInfo();
        }
    }

    public void bookTicket(String type, String pickup, String drop, String name, int age) {
        for (Bus b : buses) {
            if (b.getType().equalsIgnoreCase(type) && b.getPickupLocation().equalsIgnoreCase(pickup) && b.getDropLocation().equalsIgnoreCase(drop)) {
                if (b.bookSeats()) {
                    passengers.add(new Passenger(name, age, b.getBusNumber()));
                    System.out.println("Booking confirmed for " + name + "! Bus Number: " + b.getBusNumber() + " | Fare: ₹" + b.getFare() + " | Arrival Time: " + b.getArrivalTime());
                    return;
                } else {
                    System.out.println("Bus is full! Choose another bus.");
                    return;
                }
            }
        }
        System.out.println("No matching bus found for your criteria!");
    }

    public void cancelTicket(int busNumber, String name) {
        for (Bus b : buses) {
            if (b.getBusNumber() == busNumber) {
                for (Passenger p : passengers) {
                    if (p.getName().equalsIgnoreCase(name) && p.getBusNumber() == busNumber) {
                        passengers.remove(p);
                        b.cancelSeat();
                        System.out.println("Booking cancelled for " + name + ".");
                        return;
                    }
                }
                System.out.println("No passenger found with the given name.");
                return;
            }
        }
        System.out.println("No such bus found!");
    }
}