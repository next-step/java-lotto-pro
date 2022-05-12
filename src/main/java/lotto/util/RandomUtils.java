package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {
    public static List<Integer> generateNonDuplicateNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(0, 6));
    }
}
