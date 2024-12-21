package org.example;

public class App {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency("QuickRentals");

        Vehicle car = new Car("C001", "Sedan", 50, true);
        Vehicle motorcycle = new Motorcycle("M001", "Ducati", 30);
        Vehicle truck = new Truck("T001", "Ford F-150", 100, 1500);

        // Add vehicles to the rental agency
        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        // Create customers
        Customer customer1 = new Customer("CUST001", "Alice");
        Customer customer2 = new Customer("CUST002", "Bob");

        // Rent vehicles
        agency.rentVehicle("C001", customer1, 3); // Alice rents the car for 3 days
        agency.rentVehicle("M001", customer2, 2); // Bob rents the motorcycle for 2 days

        // Return vehicles
        agency.returnVehicle("C001", customer1); // Alice returns the car
        agency.returnVehicle("M001", customer2); // Bob returns the motorcycle

        // Try renting an unavailable vehicle
        try {
            agency.rentVehicle("T001", customer1, 5); // Alice rents the truck for 5 days
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Display all transactions using the getter method
        System.out.println("All Transactions:");
        agency.getTransactions().forEach(System.out::println);
    }
}
