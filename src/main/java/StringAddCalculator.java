import java.util.Objects;

public class StringAddCalculator {

    public int calculate(String input) {
        if(Objects.isNull(input) || input.isEmpty()) return 0;
        validate(input);
        return Integer.parseInt(input);
    }

    private void validate(String input) {
        try {
            if(Integer.parseInt(input) < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
