package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoGame {
    private static final int PRICE_LOTTO = 1_000;

    public void play() {
        int inputMoney = InputView.inputMoney();
        int manualLottoCount = InputView.inputManualLottoCount();
        int autoLottoCount = autoLottoCount(inputMoney, manualLottoCount);

        Lottos lottos = new Lottos(buy(manualLottoCount, autoLottoCount));
        OutputView.printLottos(lottos);

        List<Integer> winnerNumbers = InputView.inputWinnerNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        LottoResult lottoResult = lottos.allMatch(winnerNumbers, bonusNumber);
        double yield = lottoResult.calculateYield(investmentAmount(manualLottoCount, autoLottoCount));
        OutputView.printResult(lottoResult, yield);
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
