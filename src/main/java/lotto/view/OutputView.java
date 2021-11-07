package lotto.view;


import lotto.model.LottoNumbers;
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
  public static final String YIELD_MESSAGE = "총 수익률은 %.2f입니다.";

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

  public static void printDrawnLotto(LottoNumbers lottoNumbers) {
    System.out.println(LAST_WEEK_DRAWN_LOTTO);
    System.out.println(lottoNumbers.toString());
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
    System.out.printf(YIELD_MESSAGE, yield);
    System.out.println();
  }
}
