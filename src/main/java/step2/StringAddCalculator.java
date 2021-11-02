package step2;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        return sum(parseToIntArray(split(text)));
    }

    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static int[] parseToIntArray(String[] textNumbers) {
        int[] numbers = new int[textNumbers.length];

        for (int i = 0; i < textNumbers.length; i++) {
            numbers[i] = Integer.parseInt(textNumbers[i]);
        }

        return numbers;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
