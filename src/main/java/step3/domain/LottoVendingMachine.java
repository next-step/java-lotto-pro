package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoVendingMachine {
    private final Money LOTTO_PRICE = new Money(1000L);
    private final NumberGenerateStrategy numberGenerateStrategy;

    public LottoVendingMachine(final NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public Lottos buy(Money paidByUser) {
        List<Lotto> lottoList = new ArrayList<>();
        while (paidByUser.canBuy(LOTTO_PRICE)) {
            paidByUser = paidByUser.pay(LOTTO_PRICE);
            lottoList.add(LottoFactory.create(numberGenerateStrategy));
        }
        return new Lottos(lottoList);
    }

    public Lottos buy(Money paidByUser, List<String> manualLottoNumbers) {
        if (paidByUser.canBuy(LOTTO_PRICE.multiply(manualLottoNumbers.size()))) {
            return manualLottoNumbers.stream()
                    .map(LottoFactory::create)
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
        }
        return new Lottos(Collections.emptyList());
    }
}
