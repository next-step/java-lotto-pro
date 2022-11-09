package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.LottoCreateStrategy;

public class LottoShop {

    private final LottoCreateStrategy lottoCreateStrategy;

    public LottoShop(final LottoCreateStrategy lottoCreateStrategy) {
        this.lottoCreateStrategy = lottoCreateStrategy;
    }

    public Lottos buy(final Money payment) {
        long quantity = payment.calculateQuantity(Lotto.PRICE);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoList.add(lottoCreateStrategy.create());
        }
        return new Lottos(lottoList);
    }
}
