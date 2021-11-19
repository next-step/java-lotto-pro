package lotto;

import lotto.generator.AutoLottoGenerator;
import lotto.generator.LottoGenerator;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
  public static void run() {
    InputView inputView = new InputView();
    LottoGenerator lottoGenerator = new AutoLottoGenerator();

    PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();
    LottoQuantity lottoQuantity = purchaseAmount.countOfPurchaseLotto();
    OutputView.printPurchasedLottoQuantity(lottoQuantity);

    LottoTicket lottoTicket = new LottoTicket(lottoGenerator.generate(lottoQuantity));
    OutputView.printLottoTicket(lottoTicket);

    WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.inputWinningLottoNumbers(), inputView.inputBonusNumber());

    WinningResult winningResult = lottoTicket.match(winningLottoNumbers);
    OutputView.printWinningResult(winningResult);

    OutputView.printYield(winningResult.calculateYield(purchaseAmount));
  }

}