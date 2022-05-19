package lotto.model.generator;

import lotto.model.LottoPaper;
import lotto.model.Lottos;

public interface LottoGenerator {
    Lottos generateLottos(LottoPaper lottoPaper);

    Lottos generateLottos(Lottos selfLottos, LottoPaper lottoPaper);
}
