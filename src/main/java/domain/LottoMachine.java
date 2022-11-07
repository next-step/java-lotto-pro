package domain;

import domain.strategy.RandomNumberGenerateStrategy;

public class LottoMachine {
    public static Lottos issueLottos(int price) {
        return Lottos.createLottos(price);
    }
}
