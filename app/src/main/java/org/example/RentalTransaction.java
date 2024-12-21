import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import org.example.RentalTransaction;

public class RentalAgency {
    private String name;
    private List<Vehicle> fleet;
    private List<RentalTransaction> transactions;

    public RentalAgency(String name) {
        this.name = name;
        this.fleet = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public List<RentalTransaction> getTransactions() {
        return transactions;
    }

    public void rentVehicle(String vehicleId, Customer customer, int days) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailableForRental()) {
                if (vehicle instanceof Rentable rentable) {
                    rentable.rent(customer, days);
                    customer.rentVehicle(vehicle);
                    double cost = vehicle.calculateRentalCost(days);
                    RentalTransaction transaction = new RentalTransaction(
                            "TXN-" + (transactions.size() + 1),
                            customer, vehicle, LocalDate.now(), null, cost);
                    transactions.add(transaction);
                    System.out.println("Transaction recorded: " + transaction);
                }
                return;
            }
        }
        throw new IllegalStateException("Vehicle not available for rental.");
    }

    public void returnVehicle(String vehicleId, Customer customer) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                if (vehicle instanceof Rentable rentable) {
                    rentable.returnVehicle();
                    customer.returnVehicle(vehicle);
                    transactions.stream()
                            .filter(t -> t.getVehicle().equals(vehicle) && t.getReturnDate() == null)
                            .findFirst()
                            .ifPresent(t -> t.setReturnDate(LocalDate.now()));
                }
                return;
            }
        }
        throw new IllegalStateException("Vehicle not found in fleet.");
    }
}
