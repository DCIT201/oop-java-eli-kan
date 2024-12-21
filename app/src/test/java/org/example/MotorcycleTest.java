import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

    @Test
    void testCalculateRentalCost() {
        Motorcycle motorcycle = new Motorcycle("M001", "Ducati", 30);
        double cost = motorcycle.calculateRentalCost(4);
        assertEquals(108, cost); // 4 days * 30 * 0.9
    }

    @Test
    void testAvailabilityAfterRentalAndReturn() {
        Motorcycle motorcycle = new Motorcycle("M002", "Harley", 40);
        assertTrue(motorcycle.isAvailable());

        motorcycle.rent(new Customer("C002", "John Doe"), 5);
        assertFalse(motorcycle.isAvailable());

        motorcycle.returnVehicle();
        assertTrue(motorcycle.isAvailable());
    }
}
