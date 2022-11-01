package domain;

import domain.strategy.RandomNumberGenerateStrategy;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<Lotto> issueLottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = price; i >= Lotto.SELL_PRICE; i -= Lotto.SELL_PRICE) {
            lottos.add(new Lotto(RandomNumberGenerateStrategy.DEFAULT));
        }
        return lottos;
    }
}
