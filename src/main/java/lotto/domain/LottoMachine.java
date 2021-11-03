package lotto.domain;

import lotto.domain.startegy.generationstrategy.NumberGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private LottoMachine() {
    }

    public static Lottos buy(final Payment payment, final NumberGenerationStrategy strategy) {
        return generateLottos(payment, strategy);
    }

    private static Lottos generateLottos(final Payment payment, final NumberGenerationStrategy strategy) {
        return Lottos.from(generateAutoLottos(payment, strategy));
    }

    private static List<Lotto> generateAutoLottos(final Payment payment, final NumberGenerationStrategy strategy) {
        List<Lotto> lottos = new ArrayList<>();
        int tryCount = payment.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            lottos.add(Lotto.from(strategy.generateLottoNumbers()));
        }
        return lottos;
    }

}
