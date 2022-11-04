package step3.model;

import step3.view.InputView;
import step3.view.OutputView;

import static step3.constant.Message.System.*;

public class LottoManager {
    private static LottoGenerator lottoGenerator = new LottoGenerator();
    private static LottoCalculator calculator = new LottoCalculator();


    public void purchaseLotto() {
        inputPurchasePriceAndManualCount();
        generateLottos();
        calculateStatistics();
    }

    private void inputPurchasePriceAndManualCount() {
        String purchasePrice = InputView.inputString(TOTAL_LOTTO_PRICE_INPUT_MESSAGE);
        String manualCount = InputView.inputString(MANUAL_LOTTO_COUNT_INPUT_MESSAGE);

        lottoGenerator.setPurchasePriceAndManualCount(purchasePrice, manualCount);
    }

    private void generateLottos() {
        lottoGenerator.generateLottos();
        OutputView.outputPurchasedLotto(lottoGenerator);
    }

    private static void calculateStatistics() {
        InputView.inputLastWeekLottoNumbers(calculator);
        calculator.calculateWinnerStatistics(lottoGenerator.getLottos());
        OutputView.outputStatisticsResult(calculator);

    }

}
