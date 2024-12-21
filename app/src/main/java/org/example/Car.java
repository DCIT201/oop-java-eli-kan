// Car Class
public class Car extends Vehicle implements Rentable {
    private boolean hasAirConditioning;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasAirConditioning) {
        super(vehicleId, model, baseRentalRate);
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (hasAirConditioning ? 10 * days : 0);
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
        System.out.println("Car rented by: " + customer.getName());
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned.");
    }
}