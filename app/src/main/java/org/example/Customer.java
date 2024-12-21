// Customer Class
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Vehicle> rentedVehicles;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentedVehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void rentVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
    }

    public void returnVehicle(Vehicle vehicle) {
        rentedVehicles.remove(vehicle);
    }
}