package step3.controller;

import java.util.ArrayList;
import java.util.List;
import step3.domain.Lotto;
import step3.domain.LottoCount;
import step3.domain.LottoFactory;
import step3.domain.LottoResult;
import step3.domain.Lottos;
import step3.domain.Money;
import step3.domain.Yield;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    public static void play() {
        Money money = inputMoney();
        LottoCount manualLottoCount = inputManualLottoCount();
        LottoCount autoLottoCount = autoLottoCount(money, manualLottoCount);

        Lottos lottos = buyLottos(manualLottoCount, autoLottoCount);
        OutputView.printBuyCount(manualLottoCount, autoLottoCount);
        OutputView.printLottos(lottos);

        LottoResult lottoResult = lottos.allMatch(inputWinnerNumbers(), inputBonusNumber());
        Yield yield = lottoResult.calculateYield(totalInvestmentAmount(manualLottoCount, autoLottoCount));
        OutputView.printResult(lottoResult, yield);
    }

    private static Money inputMoney() {
        try {
            return new Money(InputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private static LottoCount inputManualLottoCount() {
        try {
            return new LottoCount(InputView.inputManualLottoCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputManualLottoCount();
        }
    }

    private static Lottos buyLottos(LottoCount manualLottoCount, LottoCount autoLottoCount) {
        try {
            List<Lotto> lottos = buy(manualLottoCount, autoLottoCount);
            return new Lottos(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLottos(manualLottoCount, autoLottoCount);
        }
    }

    static LottoCount autoLottoCount(Money money, LottoCount manualLottoCount) {
        return new LottoCount(Math.max(
                money.lottoCount(Lotto.PRICE_LOTTO) - manualLottoCount.get(),
                LottoCount.MIN_LOTTO_COUNT
        ));
    }

    private static List<Integer> inputWinnerNumbers() {
        try {
            return InputView.inputWinnerNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinnerNumbers();
        }
    }

    private static int inputBonusNumber() {
        try {
            return InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static List<Lotto> buy(LottoCount manualLottoCount, LottoCount autoLottoCount) {
        List<List<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoCount);
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            lottos.add(LottoFactory.createManualLotto(manualLottoNumber));
        }
        for (int i = 0; i < autoLottoCount.get(); i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
        return lottos;
    }

    static int totalInvestmentAmount(LottoCount manualLottoCount, LottoCount autoLottoCount) {
        return (manualLottoCount.get() + autoLottoCount.get()) * Lotto.PRICE_LOTTO;
    }
}
