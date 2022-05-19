package lotto.domain;

import lotto.controller.LottoCount;

import java.util.List;

public class LottoMachine {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    public Lottos buy(Money money) {
        LottoCount purchaseCount = LottoPrice.purchase(money);

        Lottos lottos = new Lottos();
        for (int i = 0; i < purchaseCount.count(); i++) {
            List<Integer> numbers = lottoNumberGenerator.generate();
            lottos.add(Lotto.create(numbers));
        }
        return lottos;
    }

}
