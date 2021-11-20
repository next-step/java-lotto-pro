package lotto;

import lotto.generator.AutoLottoGenerator;
import lotto.generator.LottoGenerator;
import lotto.generator.ManualLottoGenerator;
import lotto.model.*;
import lotto.model.TotalLottoQuantity;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
  public static void run() {
    InputView inputView = new InputView();
    LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
    LottoGenerator manualLottoGenerator = new ManualLottoGenerator();

    PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();
    TotalLottoQuantity totalLottoQuantity = purchaseAmount.countOfPurchaseLotto();

    ManualLottoQuantity manualLottoQuantity = totalLottoQuantity.ofManualLottoQuantity(inputView.inputManualLottoQuantity());
    AutoLottoQuantity autoLottoQuantity = totalLottoQuantity.calculateAutoLottoQuantity(manualLottoQuantity);

    LottoTicket lottoTicket = new LottoTicket(manualLottoGenerator.generate(manualLottoQuantity));
    lottoTicket.appendLottoNumbers(autoLottoGenerator.generate(autoLottoQuantity));

    OutputView.printPurchasedLottoQuantity(manualLottoQuantity, autoLottoQuantity);
    OutputView.printLottoTicket(lottoTicket);

    WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputView.inputWinningLottoNumbers(), inputView.inputBonusNumber());

    WinningResult winningResult = lottoTicket.match(winningLottoNumbers);
    OutputView.printWinningResult(winningResult);

    OutputView.printYield(winningResult.calculateYield(purchaseAmount));
  }

}