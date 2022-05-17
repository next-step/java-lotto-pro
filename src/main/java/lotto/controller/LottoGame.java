package lotto.controller;

import lotto.constant.ErrorMessage;
import lotto.model.LottoGameResult;
import lotto.model.Money;
import lotto.model.generator.LottoGenerator;
import lotto.model.LottoPaper;
import lotto.model.LottoStore;
import lotto.model.WinningLotto;
import lotto.model.Lottos;

public class LottoGame {

    private LottoGame() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static Lottos generateLottosByGenerator(Money money, LottoGenerator lottoGenerator) {
        LottoStore lottoStore = new LottoStore(money);
        LottoPaper lottoPaper = lottoStore.issueLottoPaper();
        return lottoGenerator.generateLottos(lottoPaper);
    }

    public static LottoGameResult resultWinningGame(WinningLotto winningLotto, Lottos lottos) {
        return winningLotto.compareLottos(lottos);
    }
}
