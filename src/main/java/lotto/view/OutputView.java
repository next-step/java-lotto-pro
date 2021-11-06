package lotto.view;


import lotto.constants.OutputMessage;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.MatchResult;
import lotto.model.PurchaseAmount;

import java.util.List;

import static lotto.constants.OutputMessage.*;

public class OutputView {
  public static void printInputPurchaseAmountGuideMessage() {
    System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE);
  }

  public static void printBuyCount(PurchaseAmount purchaseAmount) {
    System.out.printf(INPUT_BUY_LOTTO_COUNTS_MESSAGE, purchaseAmount.buyLottoCount());
    System.out.println();
  }

  public static void printGeneratedLottos(Lottos lottos) {
    System.out.println(lottos.toString());
  }

  public static void printDrawnLotto(Lotto lotto) {
    System.out.println(LAST_WEEK_DRAWN_LOTTO);
    System.out.println(lotto.toString());
    System.out.println();
  }

  public static void printStatisticsGuideMessage() {
    System.out.println(STATISTICS_GUIDE_MESSAGE);
    System.out.println(PERFORATION);
  }

  public static void printMatches(List<MatchResult> matchResults) {
    for (MatchResult matchResult : matchResults) {
      printMatch(matchResult);
    }
  }

  private static void printMatch(MatchResult matchResult) {
    System.out.printf(MATCH_RESULT_MESSAGE
      , matchResult.getLottoRank().getRank()
      , matchResult.getLottoRank().getMoney()
      , matchResult.getMatchCount());
    System.out.println();
  }

  public static void printYield(double yield) {
    System.out.printf(OutputMessage.YIELD_MESSAGE, yield);
    System.out.println();
  }
}
