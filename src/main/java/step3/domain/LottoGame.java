package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoGame {

    public void play() {
        Money money = inputMoney();
        int manualLottoCount = inputManualLottoCount();
        int autoLottoCount = autoLottoCount(money, manualLottoCount);

        Lottos lottos = buyLottos(manualLottoCount, autoLottoCount);
        OutputView.printBuyCount(manualLottoCount, autoLottoCount);
        OutputView.printLottos(lottos);

        LottoResult lottoResult = lottos.allMatch(inputWinnerNumbers(), inputBonusNumber());
        double yield = lottoResult.calculateYield(Money.investmentAmount(manualLottoCount, autoLottoCount));
        OutputView.printResult(lottoResult, yield);
    }

    private Money inputMoney() {
        try {
            return new Money(InputView.inputMoney());
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
        try {
            List<Lotto> lottos = buy(manualLottoCount, autoLottoCount);
            return new Lottos(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLottos(manualLottoCount, autoLottoCount);
        }
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

    public static int autoLottoCount(Money money, int manualLottoCount) {
        int autoLottoCount = money.lottoCount() - manualLottoCount;
        return Math.max(autoLottoCount, 0);
    }

    private List<Lotto> buy(int manualLottoCount, int autoLottoCount) {
        List<List<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoCount);
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            lottos.add(LottoFactory.createManualLotto(manualLottoNumber));
        }
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
        return lottos;
    }
}
