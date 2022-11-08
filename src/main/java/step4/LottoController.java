package step4;

import step4.model.LottoNumber;
import step4.model.LottoResult;
import step4.model.Lottos;
import step4.service.LottoService;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class LottoController {

    public void gameStart() {
        InputView inputView = new InputView();
        int money = inputView.readyBuyingLotto();

        LottoService lottoService = new LottoService();
        Lottos lottos = lottoService.buyLottosByMoney(money);
        inputView.printBoughtLottoCount(lottos.count());

        inputView.printLottos(lottos);

        String winningNumberText = inputView.readyWinningLotto();
        List<LottoNumber> winningNumbers = lottoService.getLottoNumbers(winningNumberText);

        int bonus = inputView.readyBonus();
        LottoResult lottoResults = lottoService.getResultComparedToWinningNumbers(winningNumbers, bonus, lottos);

        printResult(money, lottoResults);
    }

    private void printResult(int money, LottoResult lottoResult) {
        ResultView resultView = new ResultView();
        resultView.printLottoResult(lottoResult);

        resultView.printRate(lottoResult.getProfitRate(money));
    }
}
