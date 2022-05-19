package lotto.domain;

import lotto.controller.LottoCount;

public class AutoLottoGenerator {

    private final LottoGenerator generator;
    private final LottoCount lottoCount;

    public AutoLottoGenerator(LottoCount lottoCount) {
        this.generator = new LottoGenerator();
        this.lottoCount = lottoCount;
    }

    public Lottos generate() {
        return lottoCount.generateLottos(generator);
    }
}
