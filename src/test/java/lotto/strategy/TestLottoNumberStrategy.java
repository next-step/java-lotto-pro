package lotto.strategy;

import java.util.Arrays;
import java.util.List;

public class TestLottoNumberStrategy implements LottoNumberStrategy{
    @Override
    public List<Integer> generateNumbers() {
        return Arrays.asList(1,2,3,4,5,6);
    }
}
