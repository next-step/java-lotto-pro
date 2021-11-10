package lotto;

import lotto.generator.AutoLottoGenerator;
import lotto.generator.LottoGenerator;
import lotto.model.LottoBuyer;
import lotto.model.LottoNumbers;
import lotto.model.MatchResults;
import lotto.model.PurchaseAmount;
import lotto.view.InputView;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;
import static lotto.view.OutputView.printBuyCount;
import static lotto.view.OutputView.printInputWinningLottoNumbersGuideMessage;

public class LottoController {
  public static void run() {
    LottoGenerator lottoGenerator = getAutoLottoGenerator();
    PurchaseAmount purchaseAmount = inputPurchaseAmount();
    printBuyCount(purchaseAmount);

    LottoBuyer lottoBuyer = LottoBuyer.buy(purchaseAmount, lottoGenerator);
    printGeneratedLottos(lottoBuyer.getLottoTicket());

    LottoNumbers drawnLottoNumbers = InputView.inputWinningLottoNumbers();

    processStatistics(lottoBuyer, drawnLottoNumbers);
  }

  private static void processStatistics(LottoBuyer lottoBuyer, LottoNumbers drawnLottoNumbers) {
    printStatisticsGuideMessage();
    MatchResults matchResults = lottoBuyer.matchWithWinningLotto(drawnLottoNumbers);
    printMatches(matchResults.getMatchResults());
    printYield(matchResults.calculateYield(lottoBuyer.getPurchaseAmount()));
  }

  private static AutoLottoGenerator getAutoLottoGenerator() {
    return new AutoLottoGenerator();
  }
}
