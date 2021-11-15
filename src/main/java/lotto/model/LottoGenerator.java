package lotto.model;

public class LottoGenerator {
    static final String NEGATIVE_COUNT_ERR_MSG = "로또의 수는 음수일 수 없습니다.";

    private LottoGenerator() {
    }

    public static Lottos generate(int autoCount) {
        if (autoCount < 0) {
            throw new IllegalArgumentException(NEGATIVE_COUNT_ERR_MSG);
        }
        return Lottos.newInstance(autoCount, RandomNumberGenerator::generate);
    }
}
