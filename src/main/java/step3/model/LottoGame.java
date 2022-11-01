package step3.model;

import step3.veiw.InputView;
import step3.veiw.OutputView;

import java.util.stream.IntStream;

import static step3.constant.ErrorMessage.MANUAL_COUNT_UNDER_PURCHASE_COUNT;
import static step3.constant.ErrorMessage.ONLY_NUMBER_PURCHASE_PRICE_INPUT;

public class LottoGame {

    private static LottoGenerator lottoGenerator = new LottoGenerator();

    private Lottos lottos;
    private LottoNumber bonusNumber;
    private Lotto lastWeekLotto;

    public void startGame() {
        this.lottos = generateLotto();
        this.lastWeekLotto = generateLastWeekLotto();
        this.bonusNumber = generateBonusNumber();
        statisticsLotto(lottos.getSize());
    }

    private static Lottos generateLotto() {
        int price = convertIntegerByInputString(InputView.inputPurchasePrice());
        int manualCount = convertAndValidationManualCount(price, InputView.inputManualCount());

        InputView.inputManualLottoTitle();

        Lottos lottos = generateManualLotto(manualCount);
        lottos.addedLottos(lottoGenerator.generateLottos(price, manualCount));

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

    private void statisticsLotto(int lottoSize) {
        LottoResult lottoResult = lottos.calculatorLotto(lastWeekLotto, bonusNumber);
        OutputView.outputResultLottoGame(lottoSize, lottoResult);
    }

    public static int convertIntegerByInputString(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_PURCHASE_PRICE_INPUT);
        }
    }

    public static int convertAndValidationManualCount(int price, String manualCountString) {
        int manualCount = convertIntegerByInputString(manualCountString);
        if (price / 1000 < manualCount) {
            throw new IllegalArgumentException(MANUAL_COUNT_UNDER_PURCHASE_COUNT);
        }
        return manualCount;
    }

    private static Lottos generateManualLotto(int manualCount) {
        Lottos lottos = new Lottos();
        IntStream.range(0, manualCount).forEach(i -> {
            Lotto lotto = lottoGenerator.generateLotto(InputView.inputManualLotto());
            lotto.convertNumberArrayByInputNumber();
            lottos.addedLotto(lotto);
        });
        return lottos;
    }

}
