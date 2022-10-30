package lotto.domain;


import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> create() {
        Collections.shuffle(availableNumbers);
        List<Integer> numbers = availableNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}
