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

    public void bookTicket(int busNumber, String name, int age) {
        Bus bus = findBus(busNumber);
        if (bus == null) {
            System.out.println("No such bus found!");
            return;
        }

        for (Passenger p : passengers) {
            if (p.getName().equalsIgnoreCase(name) && p.getBusNumber() == busNumber) {
                System.out.println("Passenger already booked in this bus!");
                return;
            }
        }

        if (bus.bookSeats()) {
            passengers.add(new Passenger(name, age, busNumber));
            System.out.println("Booking confirmed for " + name + "! Fare: ₹" + bus.getFare() + " | Arrival Time: " + bus.getArrivalTime());
        } else {
            System.out.println("Bus is full! Choose another bus.");
        }
    }

    public void cancelTicket(int busNumber, String name) {
        Bus bus = findBus(busNumber);
        if (bus == null) {
            System.out.println("No such bus found!");
            return;
        }

        for (Passenger p : passengers) {
            if (p.getName().equalsIgnoreCase(name) && p.getBusNumber() == busNumber) {
                passengers.remove(p);
                bus.cancelSeat();
                System.out.println("Booking cancelled for " + name + ".");
                return;
            }
        }
        System.out.println("No passenger found with the given name.");
    }

    private Bus findBus(int busNumber) {
        for (Bus b : buses) {
            if (b.getBusNumber() == busNumber) return b;
        }
        return null;
    }
}