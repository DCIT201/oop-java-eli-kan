import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    void testCalculateRentalCostWithHighCargoCapacity() {
        Truck truck = new Truck("T001", "Ford F-150", 100, 1500);
        double cost = truck.calculateRentalCost(2);
        assertEquals(300, cost); // 2 days * 100 + 2 * 50
    }

    @Test
    void testCalculateRentalCostWithLowCargoCapacity() {
        Truck truck = new Truck("T002", "Toyota Hilux", 80, 800);
        double cost = truck.calculateRentalCost(3);
        assertEquals(240, cost); // 3 days * 80
    }

    @Test
    void testAvailabilityAfterRentalAndReturn() {
        Truck truck = new Truck("T003", "Volvo", 150, 2000);
        assertTrue(truck.isAvailable());

        truck.rent(new Customer("C003", "Alice"), 2);
        assertFalse(truck.isAvailable());

        truck.returnVehicle();
        assertTrue(truck.isAvailable());
    }
}
