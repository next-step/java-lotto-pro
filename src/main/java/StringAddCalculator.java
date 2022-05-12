import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATORS = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_SEPARATOR_GROUP_INDEX = 1;
    private static final int NUMBERS_GROUP_INDEX = 2;

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
            validateNumber(number);
            sum += number;
        }
        return sum;
    }

    private static String[] split(final String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(NUMBERS_GROUP_INDEX).split(matcher.group(CUSTOM_SEPARATOR_GROUP_INDEX));
        }
        return input.split(DEFAULT_SEPARATORS);
    }

    private static void validateNumber(final int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
