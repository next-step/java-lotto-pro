package step3.model;

import step3.veiw.InputView;
import step3.veiw.OutputView;

public class LottoGame {

    private static LottoGenerator lottoGenerator = new LottoGenerator();

    public void startGame() {
        Lottos lottos = generateLotto();
        statisticsLotto(lottos);
    }

    private void statisticsLotto(Lottos lottos) {
        String inputNumber = InputView.inputLastWeekLottoNumber();
        Lotto lastWeekLotto = new Lotto(inputNumber);
        lastWeekLotto.convertNumberArrayByInputNumber();
        LottoResult lottoResult = calculatorLottoGame(lottos, lastWeekLotto);
        OutputView.outputResultLottoGame(lottoGenerator, lottoResult);
    }

    private static Lottos generateLotto() {
        InputView.inputPurchasePrice(lottoGenerator);
        Lottos lottos = lottoGenerator.generateLottos();
        OutputView.outputResultGenerateLotto(lottos);
        return lottos;
    }

    private LottoResult calculatorLottoGame(Lottos lottos, Lotto lastWeekLotto) {
        LottoResult lottoResult = lottos.calculatorLotto(lastWeekLotto);
        return lottoResult;
    }

}
