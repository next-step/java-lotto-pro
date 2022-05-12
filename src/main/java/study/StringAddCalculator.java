package study;

public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return sumNumbers(convertStringArrayToIntArray(splitText(text)));
    }

    private static String[] splitText(String text) {
        return text.split(SEPARATOR);
    }

    private static int[] convertStringArrayToIntArray(String[] stringNumbers) {
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        return numbers;
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
