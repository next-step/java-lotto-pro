package lotto.domain;


import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> create(Supplier<List<Integer>> ignore) {
        Collections.shuffle(availableNumbers);
        List<Integer> numbers = availableNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}
