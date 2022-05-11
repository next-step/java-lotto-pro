import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATORS = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(final String input) {
        if (!validateInput(input)) {
            return 0;
        }
        return sumNumbers(findNumbers(input));
    }

    private static boolean validateInput(final String input) {
        return input != null && !input.isEmpty();
    }

    private static List<Integer> findNumbers(final String input) {
        final String[] stringNumbers = split(input);
        final List<Integer> numbers = new ArrayList<>();
        for (final String stringNumber : stringNumbers) {
            System.out.println(stringNumber);
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

    private static String[] split(final String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return input.split(DEFAULT_SEPARATORS);
    }
}
