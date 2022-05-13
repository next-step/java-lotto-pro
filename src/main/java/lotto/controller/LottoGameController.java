package lotto.controller;

import java.util.List;
import lotto.dto.LottoGameDTO;
import lotto.model.LottoPlayService;
import lotto.utils.InputStringUtils;
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

    public LottoGameDTO generateLottoByMoney(String moneyWord) {
        try {
            int buyLottoCount = lottoPlayService.buyLottoCount(moneyWord);
            Lottos lottos = lottoPlayService.generateLottoByCount(buyLottoCount);
            resultView.generatedLottosView(lottos);
            return new LottoGameDTO(lottos, null, false);
        } catch (IllegalArgumentException e) {
            return new LottoGameDTO(null, e.getMessage(), true);
        }
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
}
