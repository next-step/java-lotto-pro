public class Number {
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
        try {
            Double.parseDouble(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
