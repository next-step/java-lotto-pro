package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public Lottos buy() {
        Money purchaseAmount = Money.of(InputView.inputPurchaseAmount());
        LottoCount purchaseCount = LottoPrice.purchase(purchaseAmount);
        LottoCount manualCount = new LottoCount(InputView.inputManualLottoCount());

        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers(InputView.inputManualLotto(manualCount));
        Lottos buy = lottoMachine.buy(new ManualLottoGenerator(manualLottoNumbers));

        ResultView.printPurchaseCount(buy);
        ResultView.printLottos(buy);

        return buy;
    }

    public WinningStatistic checkWinning(Lottos buy) {
        String winningNumbers = InputView.inputWinningNumbers();
        String bonusBall = InputView.inputBonusBall();

        WinningLotto winnings = new WinningLotto(winningNumbers, bonusBall);

        return buy.checkWinnings(winnings);
    }

    public void printResult(WinningStatistic winningStatistic, Money purchaseAmount) {
        ResultView.printWinningStatistic(winningStatistic);
        ResultView.printRateOfReturn(winningStatistic, purchaseAmount);
    }
}
