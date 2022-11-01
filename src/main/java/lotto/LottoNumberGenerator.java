package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumberGenerator {

    static final int START_LOTTO_NUMBER_RANGE = 1;
    static final int END_LOTTO_NUMBER_RANGE = 45;

    static final int START_LOTTO_NUMBER_INDEX = 0;
    static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers = IntStream.range(START_LOTTO_NUMBER_RANGE, END_LOTTO_NUMBER_RANGE)
            .mapToObj(it -> new LottoNumber(String.valueOf(it)))
            .collect(Collectors.toList());

    @Override
    public List<Number> generate() {
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(START_LOTTO_NUMBER_INDEX, LOTTO_NUMBER_SIZE));
    }
}
