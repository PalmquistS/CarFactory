import java.util.List;

public class Car {
    private String brand;
    private String regNo;
    private String color;
    private String model;
    private String engineType;
    private int numberOfPassengers;
    private int enginePower;
    private List<String> listOfEquipment;

    public Car(String brand,
               String regNo,
               String model,
               String color,
               String engineType,
               int numberOfPassengers,
               int enginePower,
              List<String> listOfEquipment) {

        this.brand = brand;
        this.regNo = regNo;
        this.color = color;
        this.model = model;
        this.engineType = engineType;
        this.numberOfPassengers = numberOfPassengers;
        this.enginePower = enginePower;
        this.listOfEquipment = listOfEquipment;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public List<String> getListOfEquipment() {
        return listOfEquipment;
    }

    public void setListOfEquipment(List<String> listOfEquipment) {
        this.listOfEquipment = listOfEquipment;
    }
}
