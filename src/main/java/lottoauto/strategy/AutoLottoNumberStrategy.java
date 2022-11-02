package lottoauto.strategy;

import java.util.List;
import lottoauto.domain.LottoNumber;

import static java.util.Collections.*;
import static lottoauto.domain.Lotto.*;

public class AutoLottoNumberStrategy implements LottoNumberStrategy{
    @Override
    public List<Integer> generateNumbers() {

        List<Integer> numbers = LottoNumber.CACHE;
        shuffle(numbers);
        return numbers.subList(0, NUMBER_COUNT);
    }
}
