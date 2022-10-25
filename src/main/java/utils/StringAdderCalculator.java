package utils;

import java.util.List;

public class StringAdderCalculator {

    public static int splitAndSum(String text) {
        List<String> splitNumbers = StringSplitter.split(text);

        return sum(splitNumbers);
    }

    private static int sum(List<String> splitNumbers) {
        return splitNumbers.stream()
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum();
    }

}
