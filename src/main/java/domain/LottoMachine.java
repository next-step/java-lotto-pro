package domain;

public class LottoMachine {
    public static Lottos issueLottos(SelfPickLottos selfPickLottos, int money) {
        return Lottos.createLottos(selfPickLottos, money);
    }
}
