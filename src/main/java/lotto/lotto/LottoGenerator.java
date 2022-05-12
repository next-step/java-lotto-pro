package lotto.lotto;

public interface LottoGenerator {

    static LottoGenerator random() {
        return new RandomLottoGenerator();
    }

    static LottoGenerator commaSplitting(String value) {
        return new CommaSplittingLottoGenerator(value);
    }

    Lotto generate();
}
