package step3.domain.factory;

import step3.domain.lotto.LottoNumbers;

import java.util.List;

public class Manual implements LottoFactory {

    private final List<Integer> integers;

    public Manual(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public LottoNumbers create() {
        return new LottoNumbers(integers);
    }
}
