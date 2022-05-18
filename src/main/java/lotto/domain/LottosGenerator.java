package lotto.domain;

public class LottosGenerator {
    public static Lottos generateLottos(final Price price) {
        return new Lottos(price.calculateLottoCount());
    }
}
