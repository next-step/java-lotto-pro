package step3.model;

import step3.view.InputView;
import step3.view.OutputView;

public class LottoManager {
    private static LottoGenerator lottoGenerator = new LottoGenerator();
    private static LottoCalculator calculator = new LottoCalculator();


    public static void purchaseLotto() {
        generateLottos();
        calculateStatistics();
    }

    private static void generateLottos() {
        InputView.inputPurchasePrice(lottoGenerator);
        lottoGenerator.generateLottos();
        OutputView.outputPurchasedLotto(lottoGenerator.getLottos());
    }

    private static void calculateStatistics() {
        InputView.inputLastWeekLottoNumbers(calculator);
//        calculator.calculateWinnerSatistics();
        OutputView.outputStatisticsResult(calculator);
    }

}
