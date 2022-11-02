package lotto.strategy;

import java.util.List;
import lotto.domain.LottoNumber;

import static java.util.Collections.*;
import static lotto.domain.Lotto.*;

public class AutoLottoNumberStrategy implements LottoNumberStrategy{
    @Override
    public List<Integer> generateNumbers() {

        List<Integer> numbers = LottoNumber.CACHE;
        shuffle(numbers);
        return numbers.subList(0, NUMBER_COUNT);
    }
}
