package lotto.controller;

import lotto.constant.ErrorMessage;
import lotto.model.LottoGameResult;
import lotto.model.generator.LottoGenerator;
import lotto.model.LottoPaper;
import lotto.model.WinningLotto;
import lotto.model.Lottos;

public class LottoGame {

    private LottoGame() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static LottoGameResult resultWinningGame(WinningLotto winningLotto, Lottos lottos) {
        return winningLotto.compareLottos(lottos);
    }

    public static Lottos generateLottosByGenerator(LottoPaper lottoPaper, Lottos selfLottos, LottoGenerator lottoGenerator) {
        return lottoGenerator.generateLottos(selfLottos,lottoPaper);
    }
}
