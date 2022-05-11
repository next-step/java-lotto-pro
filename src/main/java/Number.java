public class Number {

    private static final int ZERO = 0;
    private final int number;

    public Number(int number) {
        validatePositiveNumber(number);
        this.number = number;
    }

    public Number(String input) {
        this.number = convertToInt(input);
    }

    public Number() {
        this.number = ZERO;
    }

    public int getNumber() {
        return number;
    }

    private void validatePositiveNumber(int number) {
        if (number < ZERO) {
            throw new RuntimeException();
        }
    }

    private int convertToInt(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    public Number addNumber(Number number) {
        return new Number(this.number + number.getNumber());
    }

}
