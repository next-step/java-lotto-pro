package step3.model;

import step3.veiw.InputView;
import step3.veiw.OutputView;

public class LottoGame {

    private static LottoGenerator lottoGenerator = new LottoGenerator();

    private Lottos lottos;
    private LottoNumber bonusNumber;
    private Lotto lastWeekLotto;

    public void startGame() {
        this.lottos = generateLotto();
        this.lastWeekLotto = generateLastWeekLotto();
        this.bonusNumber = generateBonusNumber();
        statisticsLotto();
    }

    private static Lottos generateLotto() {
        Lottos lottos = lottoGenerator.generateLottos(InputView.inputPurchasePrice());
        OutputView.outputResultGenerateLotto(lottos);
        return lottos;
    }

    private Lotto generateLastWeekLotto() {
        Lotto lastWeekLotto = lottoGenerator.generateLotto(InputView.inputLastWeekLottoNumber());
        lastWeekLotto.convertNumberArrayByInputNumber();
        return lastWeekLotto;
    }

    private LottoNumber generateBonusNumber() {
        LottoNumber lottoNumber = lottoGenerator.generateLottoNumber(InputView.inputBonusNumber());
        return lottoNumber;
    }

    private void statisticsLotto() {
        LottoResult lottoResult = calculatorLottoGame(lottos, lastWeekLotto);
        OutputView.outputResultLottoGame(lottoGenerator, lottoResult);
    }

    private LottoResult calculatorLottoGame(Lottos lottos, Lotto lastWeekLotto) {
        LottoResult lottoResult = lottos.calculatorLotto(lastWeekLotto);
        return lottoResult;
    }

}
