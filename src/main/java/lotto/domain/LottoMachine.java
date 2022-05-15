package lotto.domain;

import java.util.List;

public class LottoMachine {

    public static Lottos buy(Money money) {
        int purchaseCount = LottoPrice.purchase(money);

        Lottos lottos = new Lottos();
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = LottoGenerator.generate();
            lottos.add(Lotto.create(numbers));
        }
        return lottos;
    }
}
