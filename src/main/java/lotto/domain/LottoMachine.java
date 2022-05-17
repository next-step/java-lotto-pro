package lotto.domain;

import java.util.List;

public class LottoMachine {

    private final LottoGenerator lottoGenerator;

    public LottoMachine() {
        lottoGenerator = new LottoGenerator();
    }

    public Lottos buy(Money money) {
        int purchaseCount = LottoPrice.purchase(money);

        Lottos lottos = new Lottos();
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = lottoGenerator.generate();
            lottos.add(Lotto.create(numbers));
        }
        return lottos;
    }
}
