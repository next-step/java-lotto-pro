package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsUtil {
    private static final int END_IS_BIG = 1;

    private CollectionsUtil() {

    }

    public static List<Integer> sequentialNumbers(int start, int end) {
        if (Integer.compare(start, end) == END_IS_BIG) {
            throw new IllegalArgumentException("start 값은 end 값보다 항상 작아야 합니다.");
        }
        return IntStream.rangeClosed(start, end)
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Integer> shuffleSequentialNumbers(int start, int end) {
        List<Integer> sequentialNumbers = sequentialNumbers(start, end);
        Collections.shuffle(sequentialNumbers);
        if (sequentialNumbers.size() == 0 || isShuffled(start, end, sequentialNumbers)) {
            return sequentialNumbers;
        }
        return shuffleSequentialNumbers(start, end);
    }

    private static boolean isShuffled(int start, int end, List<Integer> sequentialNumbers) {
        return !sequentialNumbers(start, end).equals(sequentialNumbers);
    }


}
