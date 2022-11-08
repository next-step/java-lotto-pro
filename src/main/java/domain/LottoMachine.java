package domain;

public class LottoMachine {
    public static Lottos issueLottos(SelfPickLottos selfPickLottos, Money money) {
        return Lottos.createLottos(selfPickLottos, money);
    }
}
