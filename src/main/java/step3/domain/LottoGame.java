package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoGame {
    private static final int PRICE_LOTTO = 1_000;

    public void play() {
        try {
            int inputMoney = inputMoney();
            int manualLottoCount = inputManualLottoCount();
            int autoLottoCount = autoLottoCount(inputMoney, manualLottoCount);

            Lottos lottos = buyLottos(manualLottoCount, autoLottoCount);
            OutputView.printLottos(lottos);

            LottoResult lottoResult = lottos.allMatch(inputWinnerNumbers(), inputBonusNumber());
            double yield = lottoResult.calculateYield(investmentAmount(manualLottoCount, autoLottoCount));
            OutputView.printResult(lottoResult, yield);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            play();
        }
    }

    private int inputMoney() {
        try {
            return InputView.inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private int inputManualLottoCount() {
        try {
            return InputView.inputManualLottoCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputManualLottoCount();
        }
    }

    private Lottos buyLottos(int manualLottoCount, int autoLottoCount) {
        List<Lotto> lottos = buy(manualLottoCount, autoLottoCount);
        return new Lottos(lottos);
    }

    private List<Integer> inputWinnerNumbers() {
        try {
            return InputView.inputWinnerNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinnerNumbers();
        }
    }

    private int inputBonusNumber() {
        try {
            return InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    public static int autoLottoCount(int money, int manualLottoCount) {
        int autoLottoCount = money / PRICE_LOTTO - manualLottoCount;
        return Math.max(autoLottoCount, 0);
    }

    private List<Lotto> buy(int manualLottoCount, int autoLottoCount) {
        List<List<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoCount);
        OutputView.printBuyCount(manualLottoCount, autoLottoCount);
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            lottos.add(LottoFactory.createManualLotto(manualLottoNumber));
        }
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
        return lottos;
    }

    int investmentAmount(int manualLottoCount, int autoLottoCount) {
        return (manualLottoCount + autoLottoCount) * PRICE_LOTTO;
    }
}
