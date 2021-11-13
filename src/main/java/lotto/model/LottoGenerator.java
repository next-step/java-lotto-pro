package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.util.Validator;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static Lottos generate(int autoCount) {
        Validator.validateNonNegative(autoCount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            Lotto lotto = new Lotto(RandomNumberGenerator.generate());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
