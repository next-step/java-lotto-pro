package lotto;

import lotto.domain.Lotties;
import lotto.domain.LottoCount;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatus;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = Money.from(InputView.getPurchaseAmount());

        LottoCount lottoCount = LottoCount.of(purchaseAmount, InputView.getManualLottoCount());
        List<String> manualLottoNumbers = InputView.getManualLottoNumbers(lottoCount);

        Lotties myLotties = LottoGame.purchase(lottoCount, manualLottoNumbers);
        ResultView.printPurchaseLotties(myLotties, lottoCount);

        String winningLottoNumber = InputView.getWinningLottoNumber();
        int bonusNumber = InputView.getBonusNumber();

        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);

        WinningStatus winningStatus = myLotties.getWinningStatus(winningLotto);
        ResultView.printWinningStatus(winningStatus);
        ResultView.printLottoYield(purchaseAmount, winningStatus);

    }
}
