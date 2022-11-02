package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class ManualLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> create(Supplier<List<Integer>> numbersSupplier) {
        List<Integer> numbers = numbersSupplier.get();
        Collections.sort(numbers);
        return numbers;
    }
}
