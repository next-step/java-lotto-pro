package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsUtil {
    private CollectionsUtil() {

    }

    public static List<Integer> sequentialNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Integer> shuffleSequentialNumbers(int start, int end) {
        List<Integer> sequentialNumbers = sequentialNumbers(start, end);
        Collections.shuffle(sequentialNumbers);
        return sequentialNumbers;
    }
}
