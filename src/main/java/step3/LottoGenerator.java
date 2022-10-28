package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {

    private static final int FIRST_INDEX = 0;

    private LottoGenerator() {}

    public static List<Integer> createBetween(int needNumberCount, int from, int to) {
        List<Integer> numbers = generateNumbers(from, to);

        Collections.shuffle(numbers);

        return numbers.subList(FIRST_INDEX, needNumberCount);
    }

    private static List<Integer> generateNumbers(int from, int to) {
        List<Integer> numbers = new ArrayList<>();
        for (int number = from ; number <= to ; number++) {
            numbers.add(number);
        }

        return numbers;
    }
}
