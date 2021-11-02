public class StringAddCalculator {
    public static int splitAndSum(String inputText) {
        if (inputText == null || inputText.isEmpty()) return 0;

        if (inputText.matches("//(.)\n(.*)")) {
            String[] numbers = SplitInputText.splitCustomDelimiter(inputText);
            return sumStringNumberArray(numbers);
        }

        if (inputText.contains(",") || inputText.contains(":")) {
            String[] numbers = SplitInputText.splitCommaOrColon(inputText);
            return sumStringNumberArray(numbers);
        }

        return Integer.parseInt(inputText);
    }

    private static int sumStringNumberArray(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            checkValidateNumber(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static void checkValidateNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }
}
