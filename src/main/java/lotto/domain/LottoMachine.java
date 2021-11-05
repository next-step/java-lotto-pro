package lotto.domain;

import lotto.domain.startegy.generationstrategy.NumberGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private LottoMachine() {
    }

    public static Lottos buy(final Payment payment, final NumberGenerationStrategy strategy, final List<String> manualLottos) {
        return generateLottos(payment, strategy, manualLottos);
    }

    private static Lottos generateLottos(final Payment payment, final NumberGenerationStrategy strategy, final List<String> manualLottos) {
        List<Lotto> lottos = generateManualLottos(manualLottos);
        lottos.addAll(generateAutoLottos(payment.spend(manualLottos.size()), strategy));

        return Lottos.from(lottos);
    }

    private static List<Lotto> generateManualLottos(final List<String> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (String manualLotto : manualLottos) {
            lottos.add(Lotto.from(manualLotto));
        }
        return lottos;
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
