import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarFactoryTest {
    CarFactory carFactory;

    @BeforeEach
    void setUp() {
        VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator = new VehicleRegistrationNumberGenerator(List.of("ABC123"));
        carFactory = new CarFactory(vehicleRegistrationNumberGenerator, "Saab");
        //   carFactory.addModel("900", "Bensin", 90, 4,"Plus", List.of("Rattvärme", "Stolsvärme", "Krockkudde"));
        carFactory.addModel("900", "Bensin", 90, 4, List.of("Rattvärme", "Stolsvärme", "Krockkudde"));
    }

    @Test
    void test_create_car_success() throws MissingModelException, MissingPackageException {
        Car car = carFactory.createNewCar("900", "red", List.of(), List.of(""));

        assertNotNull(car);
        assertEquals("red", car.getColor());
        assertEquals("Saab", car.getBrand());
        assertEquals("ABC123", car.getRegNo());

    }

    @Test
    void test_create_car_model_success() throws MissingModelException, MissingPackageException {
        Car car = carFactory.createNewCar("900", "red", List.of(), List.of(""));

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
    void test_create_many_car_model_success() throws MissingModelException, MissingPackageException {
        Car car = carFactory.createNewCar("900", "red", List.of(), List.of(""));
        assertNotNull(car);
        assertEquals("900", car.getModel());
        assertEquals("red", car.getColor());
        assertEquals("Bensin", car.getEngineType());
        assertEquals(90, car.getEnginePower());
        assertEquals(4, car.getNumberOfPassengers());
    }

    @Test
    void test_add_list_of_equipment_to_the_car_success() throws MissingModelException, MissingPackageException {
        Car car = carFactory.createNewCar("900", "red", List.of(), List.of("Xeonljus", "Lättmetallfälgar 24\"", "Stolsvärme bak"));

        assertNotNull(car);
        // assertThat(List.of("Xeonljus, Lättmetallfälgar 24\", Stolsvärme bak, Rattvärme, Stolsvärme, Krockkudde"), Matchers.containsInAnyOrder(car.getListCarTotalEquipment()));
        assertEquals(List.of("Xeonljus", "Lättmetallfälgar 24\"", "Stolsvärme bak", "Rattvärme", "Stolsvärme", "Krockkudde"), car.getListEquipment());
    }

    @Test
    void test_check_model_specific_equipment_success() throws MissingModelException, MissingPackageException {
        Car car = carFactory.createNewCar("900", "red", List.of(), List.of());

        assertNotNull(car);
        assertEquals(List.of("Rattvärme", "Stolsvärme", "Krockkudde"), car.getListEquipment());
    }

    @Test
    void test_create_car_fail_because_missing_model() {
        MissingModelException missingModelException = assertThrows(MissingModelException.class, () -> carFactory.createNewCar("901", "red", List.of(), List.of("Xeonljus, Lättmetallfälgar 24\", Stolsvärme bak")));

        assertEquals("901", missingModelException.getMessage());


    }

    @Test
    void test_add_equipment_package_to_model_success() throws MissingModelException, MissingPackageException {
        carFactory.addPackage("Plus",List.of("Elmanövrerade backspeglar","Taklucka"));
        Car car = carFactory.createNewCar("900", "red", List.of("Plus"), List.of());
        assertEquals(List.of("Plus"), car.getListEquipmentPackages());
        assertEquals(List.of("Rattvärme", "Stolsvärme", "Krockkudde","Elmanövrerade backspeglar","Taklucka"), car.getListEquipment());
    }
}
