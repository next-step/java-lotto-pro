package step2;

public class StringAddCalculator {
    public int sum(String inputText) {
        if (validateInputText(inputText)) {
            return 0;
        }
        return 1;
    }

    private boolean validateInputText(String inputText) {
        return inputText == null || inputText.trim().isEmpty();
    }
}
