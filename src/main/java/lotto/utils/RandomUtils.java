package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {

    public static List<Integer> createRandomNumbers(int from, int to, int size) {
        List<Integer> baseNumbers = createBaseNumbers(from, to);
        Collections.shuffle(baseNumbers);

        return baseNumbers.subList(0, size).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Integer> createBaseNumbers(int from, int to) {
        return IntStream.range(from, to + 1)
                .boxed()
                .collect(Collectors.toList());
    }
}
