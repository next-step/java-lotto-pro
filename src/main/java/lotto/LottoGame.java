package lotto;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumberStrategy;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    public static final Money LOTTO_PRICE = Money.from(1_000);
    private static final LottoNumberStrategy LOTTO_NUMBER_STRATEGY = new RandomLottoNumberStrategy();

    public static Lotties purchase(Money purchaseAmount, List<String> manualLottoNumbers) {
        LottoCount lottoCount = calculateLottoCount(purchaseAmount, manualLottoNumbers);

        List<Lotto> lotties = manualLottoNumbers.stream()
                .map(Lotto::from)
                .collect(Collectors.toList());

        for (int i = 0; i < lottoCount.getAuto(); i++) {
            lotties.add(Lotto.from(LOTTO_NUMBER_STRATEGY));
        }

        return new Lotties(lotties);
    }

    public static LottoCount calculateLottoCount(Money purchaseAmount, List<String> manualLottoNumbers) {
        return LottoCount.of(purchaseAmount.divide(LOTTO_PRICE) - manualLottoNumbers.size(), manualLottoNumbers.size());
    }

}
