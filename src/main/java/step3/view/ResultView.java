package step3.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import step3.domain.LottoMatchCaseEnum;
import step3.domain.LottoMatchResult;
import step3.domain.LottoNumber;
import step3.domain.LottoTicket;
import step3.domain.LottoTickets;

public class ResultView {

  public static void printTickets(LottoTickets lottoTickets) {
    lottoTickets.getLottoTickets().forEach(ResultView::printTicket);
  }

  private static void printTicket(LottoTicket lottoTicket) {
    System.out.println(lottoTicket.getNumbers().stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toList()));
  }

  public static void printWinningPrice(LottoMatchResult lottoMatchResult) {
    System.out.println("\n당첨 통계\n---------");
    System.out.println(Arrays.stream(LottoMatchCaseEnum.values())
        .map(lottoMatchCase -> unitResultToString(lottoMatchResult, lottoMatchCase))
        .collect(Collectors.joining()));
  }

  public static String unitResultToString(LottoMatchResult lottoMatchResult,
      LottoMatchCaseEnum matchCaseEnum) {
    final int PRINT_MATCH_COUNT_LIMIT = 3;
    if (matchCaseEnum.getMatchCount() < PRINT_MATCH_COUNT_LIMIT) {
      return "";
    }
    return String.format("%d개 일치 %s(%d원)- %d\n",
        matchCaseEnum.getMatchCount(),
        matchCaseEnum == LottoMatchCaseEnum.SECOND?", 보너스 볼 일치":"",
        matchCaseEnum.getPrice(),
        lottoMatchResult.getMatchCountNum(matchCaseEnum));
  }

  public static void printWinningProfit(float profit) {
    System.out.printf("총 수익률은 %.2f입니다.", profit);
    if (profit < 1) {
      System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
  }

  public static void printTicketCount(int ticketCount) {
    System.out.printf("%d개를 구매했습니다.\n", ticketCount);
  }

  public static void printWinningNumberRequest() {
    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
  }

  public static void printBonusNumberRequest() {
    System.out.println("보너스 볼을 입력해 주세요.");
  }

  public static void printPurchasePriceRequest() {
    System.out.println("구입금액을 입력해 주세요.");

  }
}
