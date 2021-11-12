package step3.view;

import step3.domain.LottoTickets;
import step3.domain.LottoWinningPrice;

public class ResultView {

  public static void printTickets(LottoTickets lottoTickets) {
    System.out.println(lottoTickets);
  }

  public static void printWinningPrice(LottoWinningPrice lottoWinningPrice) {
    System.out.println("\n당첨 통계\n---------");
    System.out.println(lottoWinningPrice);
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
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
  }

  public static void printPurchasePriceRequest() {
    System.out.println("구입금액을 입력해 주세요.");

  }
}
