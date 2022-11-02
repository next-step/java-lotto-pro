package step3.model;

import step3.view.InputView;
import step3.view.OutputView;

public class LottoManager {
    private static LottoGenerator lottoGenerator = new LottoGenerator();
    private static LottoCalculator calculator = new LottoCalculator();

    public void purchaseLotto() {
        generateLottos();
        calculateStatistics();
    }

    private void generateLottos() {
        InputView.inputPurchasePrice(lottoGenerator);
        lottoGenerator.generateLottos();
        OutputView.outputPurchasedLotto(lottoGenerator);
    }

    private void calculateStatistics() {
        InputView.inputLastWeekLottoNumbers(calculator);
        calculator.calculateWinnerStatistics(lottoGenerator.getLottos());
        OutputView.outputStatisticsResult(calculator);

    }

}
