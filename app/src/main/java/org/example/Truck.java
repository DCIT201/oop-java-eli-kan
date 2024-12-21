
// Truck Class
public class Truck extends Vehicle implements Rentable {
    private double cargoCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double cargoCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (cargoCapacity > 1000 ? 50 * days : 0);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailableForRental()) {
            throw new IllegalStateException("Vehicle is not available.");
        }
        setAvailable(false);
        System.out.println("Truck rented by: " + customer.getName());
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck returned.");
    }
}