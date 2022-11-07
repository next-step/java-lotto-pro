package step3;

import step3.model.LottoResult;
import step3.model.Lottos;
import step3.service.LottoService;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {

    public void gameStart() {
        InputView inputView = new InputView();
        int money = inputView.readyBuyingLotto();

        LottoService lottoService = new LottoService();
        Lottos lottos = lottoService.buyLottosByMoney(money);
        inputView.printBoughtLottoCount(lottos.count());

        inputView.printLottos(lottos);

        String winningNumberText = inputView.readyWinningLotto();
        int bonus = inputView.readyBonus();
        LottoResult lottoResults = lottoService.getResultComparedToWinningNumbers(winningNumberText, bonus, lottos);

        printResult(money, lottoResults);
    }

    private void printResult(int money, LottoResult lottoResult) {
        ResultView resultView = new ResultView();
        resultView.printLottoResult(lottoResult);

        resultView.printRate(lottoResult.getProfitRate(money));
    }
}
