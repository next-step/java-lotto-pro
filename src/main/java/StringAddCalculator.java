public class StringAddCalculator {
    public static int splitAndSum(String inputText) {
        if (inputText == null || inputText.isEmpty()) return 0;
        if (inputText.contains(",")) {
            String[] numbers = inputText.split(",");
            return sumStringNumberArray(numbers);
        }
        return Integer.parseInt(inputText);
    }

    private static int sumStringNumberArray(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
