package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String FIXED_DELIMITER = "[,:]";
    public static final String USER_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static void main(String[] args) {
        System.out.println("합을 구할 문자열을 입력해주세요");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println("합은 " + splitAndSum(input));
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        Optional<String[]> tokens = getTokens(text);
        return getSum(tokens);
    }

    private static int getSum(Optional<String[]> tokens) {
        return Arrays.stream(tokens.get())
                .mapToInt(Integer::parseInt)
                .map(StringAddCalculator::parsePositiveInteger)
                .sum();
    }

    private static Optional<String[]> getTokens(String text) {
        Optional<String[]> tokens = Optional.of(text.split(FIXED_DELIMITER));
        Matcher m = Pattern.compile(USER_DELIMITER_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = Optional.of(m.group(2).split(customDelimiter));
        }
        return tokens;
    }

    private static int parsePositiveInteger(Integer integer) {
        if (integer < 0) {
            throw new RuntimeException();
        }
        return integer;
    }
}
