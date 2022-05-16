package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoIssuer {
    private static final Money LOTTO_PRICE = Money.from(1000);

    private final LottoRandomFactory lottoRandomFactory;

    public AutoLottoIssuer(LottoRandomFactory lottoRandomFactory) {
        this.lottoRandomFactory = lottoRandomFactory;
    }

    public Lottos issue(Money orderPrice) {
        List<Lotto> lottoList = new ArrayList<>();

        double lottoCount = orderPrice.divide(LOTTO_PRICE);
        validate(lottoCount);
        for (int index = 0; index < lottoCount; index++) {
            lottoList.add(lottoRandomFactory.create());
        }

        return Lottos.from(lottoList);
    }


    private void validate(double lottoCount) {
        if (!(lottoCount == Math.floor(lottoCount)) || Double.isInfinite(lottoCount)) {
            throw new IllegalArgumentException("로또 구매 금액은 로또 가격의 배수만 가능합니다.");
        }
    }
}
