package lotto.domain;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto create() {
        return new Lotto(LottoNumberGenerator.generate());
    }
}
