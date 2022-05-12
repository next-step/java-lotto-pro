package lotto.lotto;

public interface LottoGenerator {

    static LottoGenerator random() {
        return new RandomLottoGenerator();
    }

    Lotto generate();
}
