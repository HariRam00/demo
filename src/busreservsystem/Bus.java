package busreservsystem;

class Bus {
    private final int busNumber;
    private final String type;
    private final int capacity;
    private final double fare;
    private int availableSeats;
    private final String pickupLocation;
    private final String dropLocation;
    private final String arrivalTime;

    public Bus(int busNumber, String type, int capacity, double fare, String pickupLocation, String dropLocation, String arrivalTime) {
        this.busNumber = busNumber;
        this.type = type;
        this.capacity = capacity;
        this.fare = fare;
        this.availableSeats = capacity;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.arrivalTime = arrivalTime;
    }

    public boolean bookSeats() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < capacity) availableSeats++;
    }

    public int getBusNumber() { return busNumber; }
    public int getAvailableSeats() { return availableSeats; }
    public double getFare() { return fare; }
    public String getType() { return type; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public String getArrivalTime() { return arrivalTime; }

    public void displayBusInfo() {
        System.out.println("Bus Number: " + busNumber + " | Type: " + type + " | Available Seats: " + availableSeats +
                " | Pickup: " + pickupLocation + " | Drop: " + dropLocation + " | Arrival Time: " + arrivalTime + " | Fare: ₹" + fare);
    }
}