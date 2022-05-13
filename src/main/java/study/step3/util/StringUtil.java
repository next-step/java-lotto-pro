package study.step3.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    private StringUtil() {
    }

    public static List<Integer> splitAndParseInt(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> shuffleAndSlice(List<Integer> numbers, int count) {
        Collections.shuffle(numbers);
        return numbers.subList(0, count);
    }
}
