package lotto;

import java.util.List;

public class LottoNumberGenerator {
    private final LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy;

    private LottoNumberGenerator(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        this.lottoNumberGeneratorStrategy = lottoNumberGeneratorStrategy;
    }

    public static LottoNumberGenerator from(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        return new LottoNumberGenerator(lottoNumberGeneratorStrategy);
    }

    public List<LottoNumber> generate() {
        return this.lottoNumberGeneratorStrategy.generate();
    }
}