package stringaddcalculator;

public class StringAddCalculator {

    public static int splitAndSum(String inputText) {
        if (isNullOrEmpty(inputText)) {
            return 0;
        }
        if (isContainsCommaOrColon(inputText)) {
            return calculateContainsCommaOrColon(inputText);
        }
        return Integer.parseInt(inputText);
    }

    private static boolean isNullOrEmpty(String inputText) {
        if (inputText == null) {
            return true;
        }
        if (inputText.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isContainsCommaOrColon(String inputText) {
        if (inputText.contains(",")) {
            return true;
        }
        if (inputText.contains(":")) {
            return true;
        }
        return false;
    }

    private static int calculateContainsCommaOrColon(String inputText) {
        String[] numbers = inputText.split(",|:");
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
