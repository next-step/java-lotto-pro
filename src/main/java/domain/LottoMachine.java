package domain;

import domain.strategy.RandomNumberGenerateStrategy;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<Lotto> issueLottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = price; i >= Lotto.PRICE; i -= Lotto.PRICE) {
            lottos.add(new Lotto(RandomNumberGenerateStrategy.DEFAULT));
        }
        return lottos;
    }
}
