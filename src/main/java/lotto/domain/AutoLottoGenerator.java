package lotto.domain;

import lotto.controller.LottoCount;

public class AutoLottoGenerator implements LottoGenerator {

    private final LottoNumberGenerator generator;
    private final LottoCount lottoCount;

    public AutoLottoGenerator(LottoCount lottoCount) {
        this.generator = new LottoNumberGenerator();
        this.lottoCount = lottoCount;
    }

    @Override
    public Lottos generate() {
        return lottoCount.generateLottos(generator);
    }
}
