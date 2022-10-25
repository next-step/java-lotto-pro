package study;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split(",");
        int result = 0;
        if (numbers.length == 1) {
            return 1;
        }
        for (int i = 0; i < numbers.length; i++) {
            result += Integer.parseInt(numbers[i]);
        }

        return result;
    }
}
