public class StringAddCalculator {
    public static int splitAndSum(final String input) {
        if (!validateInput(input)) {
            return 0;
        }
        return 1;
    }

    private static boolean validateInput(final String input) {
        return input != null && !input.isEmpty();
    }
}
