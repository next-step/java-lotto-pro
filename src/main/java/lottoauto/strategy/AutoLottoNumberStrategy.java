package lottoauto.strategy;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static lottoauto.domain.Lotto.*;
import static lottoauto.domain.LottoNumber.MAX_NUMBER;
import static lottoauto.domain.LottoNumber.MIN_NUMBER;

public class AutoLottoNumberStrategy implements LottoNumberStrategy{
    @Override
    public List<Integer> generateNumbers() {

        List<Integer> numbers = new ArrayList<>();
        for(int i = MIN_NUMBER; i<=MAX_NUMBER; i++){
            numbers.add(i);
        }
        shuffle(numbers);
        return numbers.subList(0, NUMBER_COUNT);
    }
}
