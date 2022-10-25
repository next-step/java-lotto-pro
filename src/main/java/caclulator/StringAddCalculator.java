package caclulator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final int DELIMITER_GROUP = 1;
    private static final int OPERANDS_GROUP = 2;
    private static final String OPERAND_REGEX = "[+]?\\d*(\\.\\d+)?";

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String input) {
        if(isNullOrEmpty(input)) {
            return 0;
        }
        String[] operands = split(input);
        return calculate(mapToIntArray(operands));
    }

    private static int[] mapToIntArray(final String[] operands) {
        int[] result = new int[operands.length];
        for (int i = 0; i < operands.length; i++) {
            validateOperand(operands[i]);
            int number = Integer.parseInt(operands[i]);
            result[i] = number;
        }
        return result;
    }

    private static void validateOperand(final String operand) {
        if(!Pattern.matches(OPERAND_REGEX, operand)) {
            throw new RuntimeException();
        }
    }

    private static int calculate(final int[] operands) {
        return Arrays.stream(operands)
                .sum();
    }

    private static String[] split(final String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if(matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP);
            return matcher.group(OPERANDS_GROUP).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private static boolean isNullOrEmpty(final String input) {
        return input == null || input.isEmpty();
    }
}
