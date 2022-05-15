package lotto.controller;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.model.LottoGameResult;
import lotto.model.generator.LottoGenerator;
import lotto.model.LottoPaper;
import lotto.model.LottoStore;
import lotto.model.WinningLotto;
import lotto.utils.InputStringUtils;
import lotto.model.Lottos;

public class LottoGame {

    private static final String DELIMITER_COMMA = ",";

    private LottoGame() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static Lottos generateLottosByMoney(String moneyWord,LottoGenerator lottoGenerator) {
        LottoStore lottoStore = new LottoStore(moneyWord);
        LottoPaper lottoPaper = lottoStore.issueLottoPaper();
        return lottoGenerator.generateLottos(lottoPaper);
    }

    public static LottoGameResult resultWinningGame(Lottos lottos, String winningNumbersWord) {
        List<Integer> winningNumberList = InputStringUtils.splitToNumberList(winningNumbersWord, DELIMITER_COMMA);
        WinningLotto winningLotto = new WinningLotto(winningNumberList);
        return winningLotto.compareLottos(lottos);
    }
}
