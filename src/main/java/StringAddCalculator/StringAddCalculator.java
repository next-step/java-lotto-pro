package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }

        String[] split = text.split(",|:");
        List<Integer> numbers = parseInts(split);
        return numbers.stream()
                .reduce(0, Integer::sum);
    }


    private static List<Integer> parseInts(String[] split) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            numbers.add(parseInt(split[i]));
        }

        return numbers;
    }

    private static int parseInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(s);
    }
}
