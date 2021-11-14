package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    static final String NEGATIVE_COUNT_ERR_MSG = "로또의 수는 음수일 수 없습니다.";

    private LottoGenerator() {
    }

    public static Lottos generate(int autoCount) {
        if (autoCount < 0) {
            throw new IllegalArgumentException(NEGATIVE_COUNT_ERR_MSG);
        }
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            Lotto lotto = new Lotto(RandomNumberGenerator.generate());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
