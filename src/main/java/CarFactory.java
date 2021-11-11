import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarFactory {
    private VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator;
    private String brand;
    private Map<String, Model> models = new HashMap<>();
    private Map<String, CarPackage> carPackages = new HashMap<>();


    public CarFactory(VehicleRegistrationNumberGenerator vehicleRegistrationNumberGenerator, String brand) {
        this.vehicleRegistrationNumberGenerator = vehicleRegistrationNumberGenerator;
        this.brand = brand;
    }

    /*public Car createNewCar(String model, String color, String engineType, Integer numberOfPassengers, Integer enginePower) {
        return new Car(getBrand(), vehicleRegistrationNumberGenerator.getNextRegNo(), model, color, engineType, numberOfPassengers, enginePower);
    }*/
    public Car createNewCar(String modelAsText, String color, List<String> listOfPackages, List<String> listOfExtraEquipment) throws MissingModelException, MissingPackageException {
        Model model = models.get(modelAsText);
        if (model == null) {
            throw new MissingModelException(modelAsText);
        }
        List<String> listCarTotalEquipment = new ArrayList<>(listOfExtraEquipment);
        listCarTotalEquipment.addAll(model.getListOfStandardEquipment());
        appendPackageEquipment(modelAsText, listOfPackages, listCarTotalEquipment);
        return new Car(getBrand(),
                vehicleRegistrationNumberGenerator.getNextRegNo(),
                model.getModel(),
                color,
                model.getEngineType(),
                model.getNumberOfPassenger(),
                model.getEnginePower(),
                listOfPackages,
                listCarTotalEquipment);
    }

    private void appendPackageEquipment(String modelAsText, List<String> listOfPackages, List<String> listCarTotalEquipment) throws MissingPackageException {
        for (String carPackageName : listOfPackages) {
            CarPackage carPackage = carPackages.get(carPackageName);
            if (carPackage == null){
                throw new MissingPackageException(carPackageName);
            }
            listCarTotalEquipment.addAll(carPackage.getEquipment());
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

 public void addModel(String model, String engineType, int enginePower, int numberOfPassenger,List<String> listOfStandardEquipment) {
        models.put(model, new Model(model, engineType, enginePower, numberOfPassenger,  listOfStandardEquipment));
    }

    public void addPackage(String packageName, List<String> equipment) {
        carPackages.put(packageName, new CarPackage(packageName,equipment));
    }

    public static class Model {
        String model;
        String engineType;
        int enginePower;
        int numberOfPassenger;
        List<String> listOfStandardEquipment;

        public Model(String model, String engineType, int enginePower, int numberOfPassenger, List<String> listOfStandardEquipment) {
            this.model = model;
            this.engineType = engineType;
            this.enginePower = enginePower;
            this.numberOfPassenger = numberOfPassenger;
            this.listOfStandardEquipment = listOfStandardEquipment;
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

        public List<String> getListOfStandardEquipment() {
            return listOfStandardEquipment;
        }
    }

    private static class CarPackage {
        private String packageName;
        private List<String> equipment;

        public CarPackage(String packageName, List<String> equipment) {

            this.packageName = packageName;
            this.equipment = equipment;
        }

        public String getPackageName() {
            return packageName;
        }

        public List<String> getEquipment() {
            return equipment;
        }
    }
}
