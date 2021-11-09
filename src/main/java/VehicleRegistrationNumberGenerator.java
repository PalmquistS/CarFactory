import java.util.ArrayList;
import java.util.List;

public class VehicleRegistrationNumberGenerator {
    List<String> regNumbers;

    public VehicleRegistrationNumberGenerator(List<String> regNumbers) {
        this.regNumbers = new ArrayList<>(regNumbers);
    }

    public String getNextRegNo() {
        return regNumbers.remove(0);


    }
}
