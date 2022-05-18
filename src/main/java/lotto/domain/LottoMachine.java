package lotto.domain;

import lotto.controller.LottoCount;

import java.util.List;

public class LottoMachine {

    private final LottoGenerator lottoGenerator;

    public LottoMachine() {
        lottoGenerator = new LottoGenerator();
    }

    public Lottos buy(Money money) {
        LottoCount purchaseCount = LottoPrice.purchase(money);

        Lottos lottos = new Lottos();
        for (int i = 0; i < purchaseCount.count(); i++) {
            List<Integer> numbers = lottoGenerator.generate();
            lottos.add(Lotto.create(numbers));
        }
        return lottos;
    }

}
