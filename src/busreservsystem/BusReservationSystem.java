package busreservsystem;

import java.util.Scanner;

public class BusReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationManager manager = new ReservationManager();

        manager.addBus(101, "A/C Sleeper", 45, 550, "Kanyakumari", "Chennai", "08:00 AM","08-04-2025");
        manager.addBus(102, "Non A/C Sleeper", 40, 300, "Kanyakumari", "Chennai", "08:00 AM","08-04-2025");

        while (true) {
            System.out.println("\n========== BUS RESERVATION SYSTEM ==========");
            System.out.println("1. View Buses");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> manager.viewBuses();
                case 2 -> {
                    System.out.print("Enter bus type (A/C Sleeper, Non A/C Sleeper, etc.): ");
                    String type = sc.nextLine().trim();
                    System.out.print("Enter Date of travel (DD-MM-YYYY): ");
                    String date = sc.nextLine().trim();
                    System.out.print("Enter pickup location: ");
                    String pickup = sc.nextLine();
                    System.out.print("Enter drop location: ");
                    String drop = sc.nextLine().trim();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();

                    if (age <= 0) {
                        System.out.println("Age must be a positive number!");
                        break;
                    }

                    manager.bookTicket(type, pickup, drop, name, age,date);
                }
                case 3 -> {
                    System.out.print("Enter bus number: ");
                    int busNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    manager.cancelTicket(busNumber, name);
                }
                case 4 -> {
                    System.out.println("Exiting... Thank you for visiting!!!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option! Choose again.");
            }
        }
    }
}

