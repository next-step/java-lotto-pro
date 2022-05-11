package lotto.controller;

import lotto.constant.ErrorMessage;
import lotto.dto.LottoGameResponseDTO;
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

    public LottoGameResponseDTO inputMoney(){
        return new LottoGameResponseDTO(null,inputView.inputMoneyView(),false);
    }

    public LottoGameResponseDTO purchaseLotto(String moneyWord){
        try {
            int money = Integer.parseInt(moneyWord);
            Lottos lottos = lottoPlayService.convertMoneyToLottos(money);
            String purchaseView = resultView.resultPurchaseView(lottos);
            return new LottoGameResponseDTO(lottos,purchaseView,false);
        } catch (NumberFormatException e) {
            return new LottoGameResponseDTO(null, ErrorMessage.NOT_CONVERT_MONEY,true);
        } catch (IllegalArgumentException e) {
            return new LottoGameResponseDTO(null, e.getMessage(), true);
        }
    }
}
