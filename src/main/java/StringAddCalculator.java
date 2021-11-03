import java.util.Objects;

public class StringAddCalculator {

    public int calculate(String input) {
        if(Objects.isNull(input) || input.isEmpty()) return 0;
        return Integer.parseInt(input);
    }
}
