package step2;

public class StringCalculator {
    private final String inputValue;

    public StringCalculator(String inputValue) {
        this.inputValue = inputValue;
    }

    public int result() {
        if (inputValue == null || inputValue.isEmpty()) {
            return 0;
        }

        if (inputValue.length() >= 1) {
            return Integer.parseInt(inputValue);
        }

        throw new RuntimeException();
    }

}
