package step3.domain;

public class LottoMachine {
    private LottoMachine() {

    }

    public static Lotto getLotto(LottoCreateStrategy strategy) {
        return strategy.createLotto();
    }
}
