package lotto;

import lotto.domain.Lotties;
import lotto.domain.LottoCount;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatus;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

import static lotto.LottoGame.LOTTO_PRICE;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = Money.from(InputView.getPurchaseAmount());
        int manualLottoCount = InputView.getManualLottoCount();
        if (purchaseAmount.divide(LOTTO_PRICE) < manualLottoCount) {
            throw new IllegalArgumentException("구입금액보다 많은 로또를 수동으로 구매할 수 없습니다.");
        }
        List<String> manualLottoNumbers = InputView.getManualLottoNumbers(manualLottoCount);

        Lotties myLotties = LottoGame.purchase(purchaseAmount, manualLottoNumbers);
        LottoCount lottoCount = LottoGame.calculateLottoCount(purchaseAmount, manualLottoNumbers);
        ResultView.printPurchaseLotties(myLotties, lottoCount);
        String winningLottoNumber = InputView.getWinningLottoNumber();
        int bonusNumber = InputView.getBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);
        WinningStatus winningStatus = myLotties.getWinningStatus(winningLotto);
        ResultView.printWinningStatus(winningStatus);
        ResultView.printLottoYield(purchaseAmount, winningStatus);

    }
}
