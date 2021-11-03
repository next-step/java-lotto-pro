package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberRandomGenerator {
    private static final int SUB_START_INDEX = 0;
    private static final int RANGE_MAX_ADD_VALUE = 1;

    private LottoNumberRandomGenerator() {
    }

    public static int[] generate(int minNumber, int maxNumber, int toIndex) {
        List<Integer> lottoRangeNumbers =
            IntStream.range(minNumber, maxNumber + RANGE_MAX_ADD_VALUE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoRangeNumbers);
        return subAndSortToList(toIndex, lottoRangeNumbers);
    }

    private static int[] subAndSortToList(int toIndex, List<Integer> randomRangeNumbers) {
        List<Integer> result = randomRangeNumbers.subList(SUB_START_INDEX, toIndex);
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
