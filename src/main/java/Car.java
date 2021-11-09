public class Car {
    private String brand;
    private String regNo;
    private String color;

    public Car(String brand, String regNo, String color) {
        this.brand =brand;
        this.regNo =regNo;
        this.color = color;
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
}
