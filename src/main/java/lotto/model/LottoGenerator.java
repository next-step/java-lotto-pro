package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static Lottos generate(int autoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }
}
