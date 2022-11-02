package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoVendingMachine {
    private final Money lottoPrice;
    private final NumberGenerateStrategy numberGenerateStrategy;

    public LottoVendingMachine(final NumberGenerateStrategy numberGenerateStrategy, final Money lottoPrice) {
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.lottoPrice = lottoPrice;
    }

    public Lottos buy(Money paidByUser) {
        List<Lotto> lottoList = new ArrayList<>();
        while (paidByUser.canBuy(lottoPrice)) {
            paidByUser = paidByUser.pay(lottoPrice);
            lottoList.add(LottoFactory.create(numberGenerateStrategy));
        }
        return new Lottos(lottoList);
    }

    public Lottos buy(Money paidByUser, List<String> manualLottoNumbers) {
        if (paidByUser.canBuy(lottoPrice.multiply(manualLottoNumbers.size()))) {
            return manualLottoNumbers.stream()
                    .map(LottoFactory::create)
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
        }
        return new Lottos(Collections.emptyList());
    }
}
