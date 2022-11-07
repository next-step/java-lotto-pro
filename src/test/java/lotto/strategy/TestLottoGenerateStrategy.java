package lotto.strategy;

import java.util.Arrays;
import lotto.domain.Lotto;

public class TestLottoGenerateStrategy implements LottoGenerateStrategy{
    @Override
    public Lotto generateLotto() {
        return Lotto.create(Arrays.asList(1,2,3,4,5,6));
    }
}
