import java.util.Objects;

public class StringAddCalculator {

    public int calculate(String input) {
        if(Objects.isNull(input) || input.isEmpty()) return 0;
        validateNotNumber(input);
        int number = Integer.parseInt(input);
        if(number < 0) throw new IllegalArgumentException();
        return number;
    }

    private void validateNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
