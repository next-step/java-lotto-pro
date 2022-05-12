package lotto;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber implements LottoNumberInterface {
    protected static final List<Integer> NUMBER_RANGE = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
            .boxed()
            .collect(toList());
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> lottoNumber) {
        this.numbers = lottoNumber;
    }

    @Override
    public List<Integer> getLottoNumber() {
        sortLottoNumber();
        return numbers;
    }

    @Override
    public void sortLottoNumber() {
        Collections.sort(numbers);
    }
}
