package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoIssuer {
    private static final Money LOTTO_PRICE = Money.from(1000);

    private final LottoRandomFactory lottoRandomFactory;

    public AutoLottoIssuer(LottoRandomFactory lottoRandomFactory) {
        this.lottoRandomFactory = lottoRandomFactory;
    }

    public List<Lotto> issue(Money orderPrice) {
        List<Lotto> lottoList = new ArrayList<>();

        int lottoCount = orderPrice.divide(LOTTO_PRICE);
        for (int index = 0; index < lottoCount; index++) {
            lottoList.add(lottoRandomFactory.create());
        }

        return lottoList;
    }
}
