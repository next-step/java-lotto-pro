package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoRoleConst;
import lotto.dto.LottoGameDTO;
import lotto.model.Lotto;
import lotto.model.LottoGameResult;
import lotto.model.LottoPaper;
import lotto.model.LottoStore;
import lotto.model.WinningLotto;
import lotto.utils.InputStringUtils;
import lotto.utils.RandomNumberUtils;
import lotto.view.ResultView;
import lotto.model.Lottos;

public class LottoGameController {

    private static final String DELIMITER_COMMA = ",";

    public LottoGameDTO generateLottosByMoney(String moneyWord) {
        try {
            LottoStore lottoStore = new LottoStore(moneyWord);
            LottoPaper lottoPaper = lottoStore.issueLottoPaper();
            Lottos lottos = generateLottos(lottoPaper);
            ResultView.printLottosView(lottos);
            return new LottoGameDTO(lottos, false);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            return new LottoGameDTO(true);
        }
    }

    private Lottos generateLottos(LottoPaper lottoPaper) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int gameCount = 0; gameCount < lottoPaper.getGameCount(); gameCount++) {
            List<Integer> randomNumberToList = RandomNumberUtils
                    .generateRandomNumberToList(LottoRoleConst.LOW_NUMBER, LottoRoleConst.MAX_NUMBER,
                            LottoRoleConst.LOTTO_NUMBER_LIST_SIZE);
            lottoList.add(new Lotto(randomNumberToList));
        }
        return new Lottos(lottoList);
    }

    public LottoGameDTO resultWinningGame(Lottos lottos, String winningNumbersWord) {
        try {
            List<Integer> winningNumberList = InputStringUtils
                    .splitToNumberListByDelimiter(winningNumbersWord, DELIMITER_COMMA);
            WinningLotto winningLotto = new WinningLotto(winningNumberList);
            LottoGameResult lottoGameResult = winningLotto.compareLottos(lottos);
            ResultView.printFinalResultView(lottoGameResult, lottos);
            return new LottoGameDTO(lottos, false);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            return new LottoGameDTO(true);
        }
    }
}
