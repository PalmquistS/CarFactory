public class CarFactory {
    private VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator;
    private String brand;

    public CarFactory(VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator, String brand) {
        this.vehicleRegistrationNumberGenerator = vehicleRegistrationNumberGenerator;
        this.brand = brand;
    }

    public Car createNewCar(String color) {
        return new Car(getBrand(), vehicleRegistrationNumberGenerator.getNextRegNo(), color);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
