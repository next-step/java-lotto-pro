package step3;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoContext {

    public void gameStart() {
        InputView inputView = new InputView();
        int money = inputView.readyBuyingLotto();

        LottoMachine lottoMachine = new LottoMachine();
        int lottoCount = lottoMachine.getBoughtLottoCount(money);
        inputView.printBoughtLottoCount(lottoCount);

        List<List<Integer>> lottos = lottoMachine.generateLotto(lottoCount);
        inputView.printLottos(lottos);

        String luckyNumberText = inputView.readyLuckyLotto();
        List<LottoResult> lottoResults = lottoMachine.getResultComparedToLuckyNumbers(luckyNumberText, lottos);

        printResult(lottoMachine, money, lottoResults);
    }

    private void printResult(LottoMachine lottoMachine, int money, List<LottoResult> lottoResults) {
        ResultView resultView = new ResultView();
        resultView.printLottoResult(lottoResults);

        double rate = lottoMachine.showRate(money, lottoResults);
        resultView.printRate(rate);
    }
}
