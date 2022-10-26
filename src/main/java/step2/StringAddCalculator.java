package step2;

public class StringAddCalculator {
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
        return Integer.parseInt(inputText);
    }
}
