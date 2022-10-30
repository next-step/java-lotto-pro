package lotto.domain;

import java.util.Objects;

public class LottoStore {
    private final Money lottoUnitPrice;

    public LottoStore(final int lottoUnitPrice) {
        this(new Money(lottoUnitPrice));
    }

    public LottoStore(final Money lottoUnitPrice) {
        if (Objects.isNull(lottoUnitPrice)) {
            throw new IllegalArgumentException("금액은 null이 아니어야 합니다.");
        }

        if (lottoUnitPrice.isZero()) {
            throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
        }

        this.lottoUnitPrice = lottoUnitPrice;
    }
}
