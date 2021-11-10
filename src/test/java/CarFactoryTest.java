import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarFactoryTest {

    @Test
    void test_create_car_success() {
        VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator = new VehicleRegistrationNumberGenerator(List.of("ABC123"));
        CarFactory carFactory = new CarFactory(vehicleRegistrationNumberGenerator, "Saab");
        carFactory.addModel("900",  "Bensin", 90, 4);
        Car car = carFactory.createNewCar("900", "red");

        assertNotNull(car);
        assertEquals("red", car.getColor());
        assertEquals("Saab", car.getBrand());
        assertEquals("ABC123", car.getRegNo());

    }

    @Test
    void test_create_car_model_success() {
        VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator = new VehicleRegistrationNumberGenerator(List.of("ABC123"));
        CarFactory carFactory = new CarFactory(vehicleRegistrationNumberGenerator, "Saab");
        carFactory.addModel("900",  "Bensin", 90, 4);
        Car car = carFactory.createNewCar("900", "red");

        assertEquals("900", car.getModel());
        assertEquals("Bensin", car.getEngineType());
        assertEquals(90, car.getEnginePower());
        assertEquals(4, car.getNumberOfPassengers());
    }


    @ParameterizedTest
    @CsvSource({
            "900 Turbo, red, Bensin/Turbo, 4, 150",
            "93, red, Bensin, 4, 110",
            "93 aero, red, Bensin/Turbo,4, 190",
            "9-7x, red, Diesel/Turbo, 6, 170"
    })
    void test_create_many_car_model_success(String model, String color, String engineType, int numberOfPassenger, int enginePower) {
        VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator = new VehicleRegistrationNumberGenerator(List.of("ABC123"));
        CarFactory carFactory = new CarFactory(vehicleRegistrationNumberGenerator, "Saab");

        carFactory.addModel(model,engineType,enginePower,numberOfPassenger);
        Car car = carFactory.createNewCar(model, color);
        assertNotNull(car);
        assertEquals(model, car.getModel());
        assertEquals(color, car.getColor());
        assertEquals(engineType, car.getEngineType());
        assertEquals(enginePower, car.getEnginePower());
        assertEquals(numberOfPassenger, car.getNumberOfPassengers());
    }


}
