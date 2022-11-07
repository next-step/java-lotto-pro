package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import static java.util.Collections.*;
import static lotto.domain.Lotto.*;

public class AutoLottoGenerateStrategy implements LottoGenerateStrategy{
    @Override
    public Lotto generateLotto() {
        List<Integer> numbers = LottoNumber.CACHE;
        shuffle(numbers);
        return Lotto.create(new ArrayList<>(numbers.subList(0, NUMBER_COUNT)));
    }
}
