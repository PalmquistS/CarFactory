import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarFactoryTest {
    CarFactory carFactory;

    @BeforeEach
    void setUp() {
        VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator = new VehicleRegistrationNumberGenerator(List.of("ABC123"));
        carFactory = new CarFactory(vehicleRegistrationNumberGenerator, "Saab");
        carFactory.addModel("900", "Bensin", 90, 4, List.of("Rattvärme", "Stolsvärme", "Krockkudde"));
    }

    @Test
    void test_create_car_success() {
        Car car = carFactory.createNewCar("900", "red", List.of(""));

        assertNotNull(car);
        assertEquals("red", car.getColor());
        assertEquals("Saab", car.getBrand());
        assertEquals("ABC123", car.getRegNo());

    }

    @Test
    void test_create_car_model_success() {
        Car car = carFactory.createNewCar("900", "red", List.of(""));

        assertEquals("900", car.getModel());
        assertEquals("Bensin", car.getEngineType());
        assertEquals(90, car.getEnginePower());
        assertEquals(4, car.getNumberOfPassengers());
    }


   /*  Test for a list of cars

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
    }*/

    @Test
    void test_create_many_car_model_success() {
        Car car = carFactory.createNewCar("900", "red", List.of(""));
        assertNotNull(car);
        assertEquals("900", car.getModel());
        assertEquals("red", car.getColor());
        assertEquals("Bensin", car.getEngineType());
        assertEquals(90, car.getEnginePower());
        assertEquals(4, car.getNumberOfPassengers());
    }

    @Test
    void test_add_list_of_equipment_to_the_car_success() {
        Car car = carFactory.createNewCar("900", "red", List.of("Xeonljus", "Lättmetallfälgar 24\"", "Stolsvärme bak"));

        assertNotNull(car);
       // assertThat(List.of("Xeonljus, Lättmetallfälgar 24\", Stolsvärme bak, Rattvärme, Stolsvärme, Krockkudde"), Matchers.containsInAnyOrder(car.getListCarTotalEquipment()));
assertEquals(List.of("Xeonljus", "Lättmetallfälgar 24\"", "Stolsvärme bak", "Rattvärme", "Stolsvärme", "Krockkudde"),car.getListCarTotalEquipment());
    }

    @Test
    void test_check_model_specific_equipment_success() {
        Car car = carFactory.createNewCar("900", "red", List.of());

        assertNotNull(car);
        assertEquals(List.of("Rattvärme", "Stolsvärme", "Krockkudde"), car.getListCarTotalEquipment());
    }

    @Test
    void test_check_car_all_equipment_success() {
        Car car = carFactory.createNewCar("900", "red", List.of("Xeonljus, Lättmetallfälgar 24\", Stolsvärme bak"));

        assertNotNull(car);
    }
}
