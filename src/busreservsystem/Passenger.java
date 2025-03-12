package busreservsystem;

class Passenger {
    private final String name;
    private final int busNumber;

    public Passenger(String name, int age, int busNumber) {
        this.name = name;
        this.busNumber = busNumber;
    }

    public String getName() { return name; }
    public int getBusNumber() { return busNumber; }
}
