import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {

    @Test
    void testAddVehicle() {
        RentalAgency agency = new RentalAgency("QuickRentals");
        Vehicle car = new Car("C001", "Sedan", 50, true);

        agency.addVehicle(car);
        List<Vehicle> fleet = agency.getFleet();

        assertEquals(1, fleet.size());
        assertEquals("C001", fleet.get(0).getVehicleId());
    }

    @Test
    void testRentVehicle() {
        RentalAgency agency = new RentalAgency("QuickRentals");
        Vehicle car = new Car("C001", "Sedan", 50, true);
        agency.addVehicle(car);

        Customer customer = new Customer("CUST001", "Alice");
        agency.rentVehicle("C001", customer, 3);

        assertFalse(car.isAvailable());
        assertEquals(1, agency.getTransactions().size());
    }

    @Test
    void testReturnVehicle() {
        RentalAgency agency = new RentalAgency("QuickRentals");
        Vehicle car = new Car("C001", "Sedan", 50, true);
        agency.addVehicle(car);

        Customer customer = new Customer("CUST001", "Bob");
        agency.rentVehicle("C001", customer, 3);
        agency.returnVehicle("C001", customer);

        assertTrue(car.isAvailable());
        assertNotNull(agency.getTransactions().get(0).getReturnDate());
    }
}
