package lotto.controller;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.dto.LottoGameDTO;
import lotto.model.LottoPlayService;
import lotto.utils.InputStringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.vo.Lottos;

public class LottoGameController {

    private static final String DELIMITER_COMMA = ",";

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoPlayService lottoPlayService;

    public LottoGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.lottoPlayService = new LottoPlayService();
    }

    public LottoGameDTO inputMoney(){
        return new LottoGameDTO(null,inputView.inputMoneyView(),false);
    }

    public LottoGameDTO purchaseLotto(String moneyWord){
        try {
            int money = Integer.parseInt(moneyWord);
            Lottos lottos = lottoPlayService.convertMoneyToLottos(money);
            String purchaseView = resultView.resultPurchaseView(lottos);
            return new LottoGameDTO(lottos,purchaseView,false);
        } catch (NumberFormatException e) {
            return new LottoGameDTO(null, ErrorMessage.NOT_CONVERT_MONEY,true);
        } catch (IllegalArgumentException e) {
            return new LottoGameDTO(null, e.getMessage(), true);
        }
    }

    public LottoGameDTO generateLottos(LottoGameDTO lottoGameDTO){
        Lottos lottos = lottoPlayService.generateLottosByPlayCount(lottoGameDTO.getLottos().getPlayCount());
        String generatedLottosView = resultView.generatedLottosView(lottos);
        return new LottoGameDTO(lottos,generatedLottosView,false);
    }

    public LottoGameDTO inputWinningNumbers() {
        String inputWinningNumbersView = inputView.inputWinningNumbersView();
        return new LottoGameDTO(null,inputWinningNumbersView,false);
    }

    public LottoGameDTO playLottoGame(LottoGameDTO lottoGameDTO, String winningNumbersWord) {
        try {
            Lottos lottos = lottoGameDTO.getLottos();
            List<Integer> winningNumberList = InputStringUtils.splitToNumberListByDelimiter(winningNumbersWord, DELIMITER_COMMA);
            lottoPlayService.playLottoGame(lottos,winningNumberList);
            String totalResultView = resultView.totalResultView(lottos);
            return new LottoGameDTO(lottos,totalResultView,false);
        }catch (IllegalArgumentException e){
            return new LottoGameDTO(null, e.getMessage(), true);
        }
    }
}
