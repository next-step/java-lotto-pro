package lotto;

import lotto.generator.AutoLottoGenerator;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
  public static void run() {
    InputView inputView = new InputView();

    PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();
    LottoQuantity lottoQuantity = purchaseAmount.countOfPurchaseLotto();
    OutputView.printPurchasedLottoQuantity(lottoQuantity);

    LottoTicket lottoTicket = new LottoTicket(lottoQuantity.makeLottoNumbersAsQuantity(getAutoLottoGenerator()));
    OutputView.printLottoTicket(lottoTicket);

    WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.inputWinningLottoNumbers(), inputView.inputBonusNumber());

    WinningResult winningResult = lottoTicket.match(winningLottoNumbers);
    OutputView.printWinningResult(winningResult);

    OutputView.printYield(winningResult.calculateYield(purchaseAmount));
  }

  private static AutoLottoGenerator getAutoLottoGenerator() {
    return new AutoLottoGenerator();
  }
}
