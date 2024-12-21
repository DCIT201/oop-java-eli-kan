import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testRentAndReturnVehicle() {
        Customer customer = new Customer("CUST001", "Bob");
        Vehicle car = new Car("C001", "Sedan", 50, true);

        customer.rentVehicle(car);
        assertEquals(1, customer.getRentedVehicles().size());

        customer.returnVehicle(car);
        assertEquals(0, customer.getRentedVehicles().size());
    }
}
