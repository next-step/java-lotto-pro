import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATORS = ",|:";

    public static int splitAndSum(final String input) {
        if (!validateInput(input)) {
            return 0;
        }
        return sumNumbers(splitInput(input));
    }

    private static boolean validateInput(final String input) {
        return input != null && !input.isEmpty();
    }

    private static List<Integer> splitInput(final String input) {
        final String[] stringNumbers = input.split(DEFAULT_SEPARATORS);
        final List<Integer> numbers = new ArrayList<>();
        for (final String stringNumber : stringNumbers) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        return numbers;
    }

    private static int sumNumbers(final List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
