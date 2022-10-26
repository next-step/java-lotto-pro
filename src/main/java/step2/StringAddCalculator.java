package step2;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public int sum(String inputText) {
        if (validateInputText(inputText)) {
            return 0;
        }
        return splitAndSum(inputText);
    }

    private boolean validateInputText(String inputText) {
        return inputText == null || inputText.trim().isEmpty();
    }

    private int splitAndSum(String inputText) {
        String[] stringNumbers = inputText.split(DEFAULT_DELIMITER);
        int result = 0;
        for (String stringNumber : stringNumbers) {
            result += Integer.parseInt(stringNumber);
        }
        return result;
    }
}
