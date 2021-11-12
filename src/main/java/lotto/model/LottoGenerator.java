package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static Collection<Lotto> generate(int autoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return lottos;
    }
}
