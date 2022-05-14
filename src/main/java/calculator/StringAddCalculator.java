package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String splitRegex = ",|:";
        String splitTarget = input;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            splitRegex = m.group(1);
            splitTarget = m.group(2);
        }

        String[] targets = splitTarget.split(splitRegex);
        if (targets.length == 1) {
            return Integer.parseInt(targets[0]);
        }

        for (String target : targets ) {
            if (Integer.parseInt(target) < 0) {
                throw new RuntimeException("음수는 계산할 수 없습니다.");
            }
        }

        return Arrays.stream(targets).mapToInt(Integer::parseInt).sum();
    }
}
