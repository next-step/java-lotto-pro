package study;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isNullOrEmptyString(input)) return 0;
        String[] numbers = input.split(",|:");
        if (isOnlyNumber(numbers)) return 1;
        int result = caculate(numbers);

        return result;
    }

    private static boolean isOnlyNumber(String[] numbers) {
        if (numbers.length == 1) {
            return true;
        }
        return false;
    }

    private static int caculate(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }

    private static boolean isNullOrEmptyString(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }
}
