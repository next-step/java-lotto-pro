package step3.domain.factory;

import step3.domain.lotto.LottoNumbers;
import step3.domain.lotto.LottoType;

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

    @Override
    public LottoType getLottoType() {
        return LottoType.MANUAL;
    }
}
