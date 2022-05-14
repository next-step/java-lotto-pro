package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        Splitter splitter = new Splitter(input);
        String[] targets = splitter.getSplitResult();

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
