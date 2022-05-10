package stringcalculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (isNull(input) || input.isEmpty()) {
            return 0;
        }

        if (input.contains(",")) {
            String[] values = input.split(",");
            int result = 0;
            for (String value : values) {
                result += Integer.parseInt(value);
            }
            return result;
        }

        return Integer.parseInt(input);
    }

    private static boolean isNull(String input) {
        return input == null;
    }
}
