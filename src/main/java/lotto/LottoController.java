package lotto;

import lotto.generator.AutoLottoGenerator;
import lotto.model.*;
import lotto.model.TotalLottoQuantity;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
  public static void run() {
    InputView inputView = new InputView();
    AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();

    PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();
    TotalLottoQuantity totalLottoQuantity = TotalLottoQuantity.of(purchaseAmount, inputView.inputManualLottoQuantity());

    LottoTicket lottoTicket = inputView.inputManualLottoNumbers(totalLottoQuantity.toManualQuantity());
    lottoTicket.appendLottoNumbers(autoLottoGenerator.generate(totalLottoQuantity.toAutoQuantity()));

    OutputView.printPurchasedLottoQuantity(totalLottoQuantity);
    OutputView.printLottoTicket(lottoTicket);

    WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.inputWinningLottoNumbers(), inputView.inputBonusNumber());

    WinningResult winningResult = lottoTicket.match(winningLottoNumbers);
    OutputView.printWinningResult(winningResult);

    OutputView.printYield(winningResult.calculateYield(purchaseAmount));
  }

}