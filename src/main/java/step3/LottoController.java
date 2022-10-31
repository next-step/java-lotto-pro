package step3;

import step3.model.LottoResults;
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

        String luckyNumberText = inputView.readyLuckyLotto();
        LottoResults lottoResults = lottoService.getResultComparedToLuckyNumbers(luckyNumberText, lottos);

        printResult(money, lottoResults);
    }

    private void printResult( int money, LottoResults lottoResults) {
        ResultView resultView = new ResultView();
        resultView.printLottoResult(lottoResults);

        resultView.printRate(lottoResults.showRate(money));
    }
}
