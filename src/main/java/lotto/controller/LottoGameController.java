package lotto.controller;

import java.util.List;
import lotto.constant.LottoRoleConst;
import lotto.dto.LottoGameDTO;
import lotto.model.Lotto;
import lotto.model.LottoPaper;
import lotto.model.LottoPlayService;
import lotto.model.LottoStore;
import lotto.utils.InputStringUtils;
import lotto.utils.RandomNumberUtils;
import lotto.view.ResultView;
import lotto.model.Lottos;

public class LottoGameController {

    private static final String DELIMITER_COMMA = ",";

    private final ResultView resultView;
    private final LottoPlayService lottoPlayService;

    public LottoGameController() {
        this.resultView = new ResultView();
        this.lottoPlayService = new LottoPlayService();
    }

    public LottoGameDTO playLottoGame(LottoGameDTO lottoGameDTO, String winningNumbersWord) {
        try {
            Lottos lottos = lottoGameDTO.getLottos();
            List<Integer> winningNumberList = InputStringUtils
                    .splitToNumberListByDelimiter(winningNumbersWord, DELIMITER_COMMA);
            lottoPlayService.playLottoGame(lottos, winningNumberList);
            resultView.totalResultView(lottos);
            return new LottoGameDTO(lottos, null, false);
        } catch (IllegalArgumentException e) {
            return new LottoGameDTO(null, e.getMessage(), true);
        }
    }

    public LottoGameDTO generateLottos(String moneyWord) {
        try {
            LottoStore lottoStore = new LottoStore(moneyWord);
            LottoPaper lottoPaper = lottoStore.issueLottoPaper();
            Lottos lottos = generateLotto(lottoPaper);
            ResultView.printLottosView(lottos);
            return new LottoGameDTO(lottos, null, false);
        } catch (IllegalArgumentException e) {
            ResultView.printConsle(e.getMessage());
            return new LottoGameDTO(null, null, true);
        }
    }

    private Lottos generateLotto(LottoPaper lottoPaper) {
        Lottos lottos = new Lottos();
        for (int gameCount = 0; gameCount < lottoPaper.getGameCount(); gameCount++) {
            List<Integer> randomNumberToList = RandomNumberUtils
                    .generateRandomNumberToList(LottoRoleConst.LOW_NUMBER, LottoRoleConst.MAX_NUMBER,
                            LottoRoleConst.LOTTO_NUMBER_LIST_SIZE);
            lottos.addLotto(new Lotto(randomNumberToList));
        }
        return lottos;
    }
}
