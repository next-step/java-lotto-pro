import java.util.regex.Pattern;

public class Number {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    private final int number;

    public Number(String text) {
        validateNumeric(text);
        int number = Integer.parseInt(text);
        validateNegative(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumeric(String text) {
        if (!NUMBER_PATTERN.matcher(text).matches()) {
            throw new RuntimeException();
        }
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
