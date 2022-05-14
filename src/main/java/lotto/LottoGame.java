package lotto;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberStrategy;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final Money LOTTO_PRICE = Money.from(1_000);
    private static final LottoNumberStrategy LOTTO_NUMBER_STRATEGY = new RandomLottoNumberStrategy();

    public static Lotties purchase(Money purchaseAmount) {
        List<Lotto> lotties = new ArrayList<>();

        while (purchaseAmount.isMoreThanOrEqual(LOTTO_PRICE)) {
            lotties.add(Lotto.create(LOTTO_NUMBER_STRATEGY));
            purchaseAmount = purchaseAmount.minus(LOTTO_PRICE);
        }

        return new Lotties(lotties);
    }
}
