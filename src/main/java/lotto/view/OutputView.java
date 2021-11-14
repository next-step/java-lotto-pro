package lotto.view;


import lotto.constants.LottoRank;
import lotto.model.LottoTicket;
import lotto.model.MatchResult;
import lotto.model.PurchaseAmount;

import java.util.List;


public class OutputView {
  public static final String INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
  public static final String INPUT_BUY_LOTTO_COUNTS_MESSAGE = "%d개를 구매했습니다.";
  public static final String LAST_WEEK_DRAWN_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
  public static final String STATISTICS_GUIDE_MESSAGE = "당첨 통계";
  public static final String PERFORATION = "-------";
  public static final String MATCH_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개";
  public static final String MATCH_BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
  public static final String YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
  private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

  public static void printInputPurchaseAmountGuideMessage() {
    System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE);
  }

  public static void printBuyCount(PurchaseAmount purchaseAmount) {
    System.out.printf(INPUT_BUY_LOTTO_COUNTS_MESSAGE, purchaseAmount.buyLottoCount());
    System.out.println();
  }

  public static void printGeneratedLottos(LottoTicket lottoTicket) {
    System.out.println(lottoTicket.toString());
  }

  public static void printInputWinningLottoNumbersGuideMessage() {
    System.out.println(LAST_WEEK_DRAWN_LOTTO);
  }

  public static void printInputBonusNumberGuideMessage() {
    System.out.println(INPUT_BONUS_NUMBER);
  }

  public static void printStatisticsGuideMessage() {
    System.out.println(STATISTICS_GUIDE_MESSAGE);
    System.out.println(PERFORATION);
  }

  public static void printMatches(List<MatchResult> matchResults) {
    for (int i = matchResults.size() - 1; i >= 0; i--) {
      printMatch(matchResults.get(i));
    }
  }

  private static void printMatch(MatchResult matchResult) {
    String resultMessage = MATCH_RESULT_MESSAGE;
    if (matchResult.getLottoRank().equals(LottoRank.SECOND)) {
      resultMessage = MATCH_BONUS_RESULT_MESSAGE;
    }
    System.out.printf(resultMessage
      , matchResult.getLottoRank().getRank()
      , matchResult.getLottoRank().getMoney()
      , matchResult.getMatchCount());
    System.out.println();
  }

  public static void printYield(double yield) {
    System.out.printf(YIELD_MESSAGE, yield);
    System.out.println();
  }
}
