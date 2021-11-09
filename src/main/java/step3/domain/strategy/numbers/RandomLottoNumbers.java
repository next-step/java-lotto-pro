package step3.domain.strategy.numbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import step3.domain.LottoNumbers;
import step3.domain.constance.LottoConstant;

public class RandomLottoNumbers implements NumbersStrategy {

    private static final int SUB_START_INDEX = 0;
    private static final int RANGE_MAX_ADD_VALUE = 1;
    private static final List<Integer> lottoRangeNumbers;

    static {
        lottoRangeNumbers =
            IntStream.range(LottoConstant.MIN_NUMBER_RANGE, LottoConstant.MAX_NUMBER_RANGE + RANGE_MAX_ADD_VALUE)
                .boxed()
                .collect(Collectors.toList());
    }

    public RandomLottoNumbers() {
    }

    @Override
    public List<Integer> getNumbers() {
        return getLottoNumbers();
    }

    private static List<Integer> getLottoNumbers() {
        Collections.shuffle(lottoRangeNumbers);
        List<Integer> result = lottoRangeNumbers.subList(SUB_START_INDEX, LottoNumbers.MAX_LOTTO_NUMBERS_SIZE);
        Collections.sort(result);
        return result;
    }
}
