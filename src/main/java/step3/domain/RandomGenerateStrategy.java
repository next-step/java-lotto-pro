package step3.domain;

import static step3.domain.LottoNumber.MAX_NUMBER;
import static step3.domain.LottoNumber.MIN_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerateStrategy implements LottoGenerateStrategy{
    public static final List<Integer> LOTTO_ALL_NUMBERS = IntStream
        .rangeClosed(MIN_NUMBER, MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());

    @Override
    public List<Integer> generate() {
        Collections.shuffle(LOTTO_ALL_NUMBERS);
        return LOTTO_ALL_NUMBERS;
    }
}
