import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCalculateRentalCostWithAirConditioning() {
        Car car = new Car("C001", "Sedan", 50, true);
        double cost = car.calculateRentalCost(3);
        assertEquals(180, cost); // 3 days * (50 + 10)
    }

    @Test
    void testCalculateRentalCostWithoutAirConditioning() {
        Car car = new Car("C002", "Hatchback", 40, false);
        double cost = car.calculateRentalCost(5);
        assertEquals(200, cost); // 5 days * 40
    }

    @Test
    void testAvailabilityAfterRentalAndReturn() {
        Car car = new Car("C003", "SUV", 70, true);
        assertTrue(car.isAvailable());

        car.rent(new Customer("C001", "John Doe"), 3);
        assertFalse(car.isAvailable());

        car.returnVehicle();
        assertTrue(car.isAvailable());
    }
}
