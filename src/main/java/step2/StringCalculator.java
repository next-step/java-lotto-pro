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

        if (inputValue.length() == 1) {
            return Integer.parseInt(inputValue);
        }

        if (inputValue.length() > 1) {
            String[] split = inputValue.split(",");
            return sum(split);
        }

        throw new RuntimeException();
    }

    private int sum(String[] split) {
        int result = 0;
        for (int index = 0; index < split.length; index++) {
            result += Integer.parseInt(split[index]);
        }
        return result;
    }

}
