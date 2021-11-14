package lotto;

import lotto.generator.AutoLottoGenerator;
import lotto.generator.LottoGenerator;
import lotto.model.*;
import lotto.view.InputView;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;
import static lotto.view.OutputView.printBuyCount;

public class LottoController {
  public static void run() {
    LottoGenerator lottoGenerator = getAutoLottoGenerator();
    PurchaseAmount purchaseAmount = inputPurchaseAmount();
    printBuyCount(purchaseAmount);

    LottoTicket lottoTicket = purchaseAmount.buyLottoTicket(lottoGenerator);
    printGeneratedLottos(lottoTicket);

    LottoNumbers drawnLottoNumbers = InputView.inputWinningLottoNumbers();
    int bonusNumber = InputView.inputBonusNumber();

    processStatistics(purchaseAmount, lottoTicket, drawnLottoNumbers, bonusNumber);
  }

  private static void processStatistics(PurchaseAmount purchaseAmount,
                                        LottoTicket lottoTicket,
                                        LottoNumbers drawnLottoNumbers,
                                        int bonusNumber) {
    printStatisticsGuideMessage();
    MatchResults matchResults = lottoTicket.totalWinningResults(drawnLottoNumbers, bonusNumber);
    printMatches(matchResults.getMatchResults());
    printYield(matchResults.calculateYield(purchaseAmount));
  }

  private static AutoLottoGenerator getAutoLottoGenerator() {
    return new AutoLottoGenerator();
  }
}
