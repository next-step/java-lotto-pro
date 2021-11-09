public class StringAddCalculator {

    public static final int NUMBER_ZERO = 0;

    public static int splitAndSum(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return NUMBER_ZERO;
        }
        String[] numbers = NumberFactory.createNumberArray(inputText);
        return sumStringNumberArray(numbers);
    }

    private static int sumStringNumberArray(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            NegativeNumberValidation.isNegative(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
