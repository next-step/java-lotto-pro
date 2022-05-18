package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {
    public static Lottos generateLottos(final Price price) {
        return new Lottos(price.calculateLottoCount());
    }

    public static Lottos generateLottosManual(final LottosManual lottosManual) {
        return new Lottos(lottosManual);
    }

    public static Lottos generateLottosAuto(final LottosManualCount lottosManualCount, final Price price) {
        return new Lottos(price.calculateLottoAutoCount(lottosManualCount));
    }

    public static Lottos mergeLottos(final Lottos manualLottos, final Lottos autoLottos) {
        final List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos.getLottos());
        lottos.addAll(autoLottos.getLottos());
        return new Lottos(lottos);
    }
}
