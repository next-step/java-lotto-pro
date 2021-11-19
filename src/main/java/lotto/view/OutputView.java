package lotto.view;

import lotto.model.LottoRank;
import lotto.model.LottoQuantity;
import lotto.model.LottoTicket;
import lotto.model.RankCount;
import lotto.model.WinningResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
  private static final String INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String OUTPUT_PURCHASED_LOTTO_QUANTITY_MESSAGE = "%s개를 구매했습니다.";
  private static final String INPUT_LAST_WEEK_DRAWN_LOTTO_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
  private static final String STATISTICS_GUIDE_MESSAGE = "당첨 통계";
  private static final String PERFORATION = "-------";
  private static final String MATCH_RESULT_MESSAGE = "%d개 일치 (%d원)- %s개";
  private static final String MATCH_BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- %s개";
  private static final String YIELD_MESSAGE = "총 수익률은 %.2f입니다.";

  public static void printInputPurchaseAmountGuideMessage() {
    System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE);
  }

  public static void printInputWinningLottoNumbersGuideMessage() {
    System.out.println(INPUT_LAST_WEEK_DRAWN_LOTTO_GUIDE_MESSAGE);
  }

  public static void printInputBonusNumberGuideMessage() {
    System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
  }

  public static void printPurchasedLottoQuantity(LottoQuantity lottoQuantity) {
    System.out.printf(OUTPUT_PURCHASED_LOTTO_QUANTITY_MESSAGE, lottoQuantity);
    System.out.println();
  }

  public static void printLottoTicket(LottoTicket lottoTicket) {
    System.out.println(lottoTicket);
  }

  public static void printWinningResult(WinningResult winningResult) {
    System.out.println();
    System.out.println(STATISTICS_GUIDE_MESSAGE);
    System.out.println(PERFORATION);
    printResultsByRank(winningResult);
  }

  private static void printResultsByRank(WinningResult winningResult) {
    Map<LottoRank, RankCount> result = winningResult.getWinningResult();

    List<LottoRank> lottoRanks = new ArrayList<>(result.keySet());
    Collections.reverse(lottoRanks);

    for (LottoRank lottoRank : lottoRanks) {
      if (lottoRank.equals(LottoRank.MISS)) continue;

      String message = MATCH_RESULT_MESSAGE;
      message = getSecondRankMessage(lottoRank, message);

      System.out.printf(message, lottoRank.getMatchCount(), lottoRank.getReward(), result.get(lottoRank));
      System.out.println();
    }
  }

  private static String getSecondRankMessage(LottoRank lottoRank, String message) {
    if (lottoRank.equals(LottoRank.SECOND)) {
      message = MATCH_BONUS_RESULT_MESSAGE;
    }
    return message;
  }

  public static void printYield(double yield) {
    System.out.printf(YIELD_MESSAGE, yield);
    System.out.println();
  }

}