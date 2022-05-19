package lotto.domain;

public class LottoMachine {

    public Lottos buy(LottoGenerator lottoGenerator) {
        return lottoGenerator.generate();
    }

}
