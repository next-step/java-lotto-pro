package step3.domain.numbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers implements NumbersStrategy {

    private static final int SUB_START_INDEX = 0;
    private static final int RANGE_MAX_ADD_VALUE = 1;
    private final int rangeMin;
    private final int rangeMax;
    private final int randomNumbersCount;
    private int[] numbers;

    public RandomNumbers(int rangeMin, int rangeMax, int randomNumbersCount) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.randomNumbersCount = randomNumbersCount;
        generate();
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }

    private void generate() {
        List<Integer> lottoRangeNumbers =
            IntStream.range(rangeMin, rangeMax + RANGE_MAX_ADD_VALUE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoRangeNumbers);
        numbers = subAndSortToList(lottoRangeNumbers);
    }

    private int[] subAndSortToList(List<Integer> randomRangeNumbers) {
        List<Integer> result = randomRangeNumbers.subList(SUB_START_INDEX, randomNumbersCount);
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
