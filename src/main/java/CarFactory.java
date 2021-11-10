import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator;
    private String brand;
    private Map<String, Model> models = new HashMap<>();


    public CarFactory(VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator, String brand) {
        this.vehicleRegistrationNumberGenerator = vehicleRegistrationNumberGenerator;
        this.brand = brand;
    }

    /*public Car createNewCar(String model, String color, String engineType, Integer numberOfPassengers, Integer enginePower) {
        return new Car(getBrand(), vehicleRegistrationNumberGenerator.getNextRegNo(), model, color, engineType, numberOfPassengers, enginePower);
    }*/
    public Car createNewCar(String modelAsText, String color) {
        Model model = models.get(modelAsText);
        if (model == null) {
            throw new RuntimeException("Unknown model " + model);
        }
        return new Car(getBrand(), vehicleRegistrationNumberGenerator.getNextRegNo(), model.getModel(), color, model.getEngineType(), model.getNumberOfPassenger(), model.getEnginePower());
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void addModel(String model, String engineType, int enginePower, int numberOfPassenger) {
        models.put(model, new Model(model, engineType, enginePower, numberOfPassenger));
    }

    public static class Model {
        String model;
        String engineType;
        int enginePower;
        int numberOfPassenger;

        public Model(String model, String engineType, int enginePower, int numberOfPassenger) {
            this.model = model;
            this.engineType = engineType;
            this.enginePower = enginePower;
            this.numberOfPassenger = numberOfPassenger;
        }

        public String getModel() {
            return model;
        }


        public String getEngineType() {
            return engineType;
        }


        public int getEnginePower() {
            return enginePower;
        }


        public int getNumberOfPassenger() {
            return numberOfPassenger;
        }


    }
}
