package lotto.controller;

import lotto.constant.ErrorMessage;
import lotto.dto.LottoGameDTO;
import lotto.model.LottoPlayService;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.vo.Lottos;

public class LottoGameController {

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

    public LottoGameDTO generateLottos(Lottos requestLottos){
        Lottos lottos = lottoPlayService.generateLottosByPlayCount(requestLottos.getPlayCount());
        String generatedLottosView = resultView.generatedLottosView(lottos);
        return new LottoGameDTO(lottos,generatedLottosView,false);
    }
}
