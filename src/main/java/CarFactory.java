public class CarFactory {
    private String brand;

    public CarFactory(String brand) {
        this.brand = brand;
    }

    public Car createNewCar(String color) {
        return new Car(getBrand(), color);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
