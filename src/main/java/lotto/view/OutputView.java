package lotto.view;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.LottoRank;
import lotto.domain.winning.WinningResult;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            List<Integer> lottoNumbers = lottoTicket.convertLottoNumbers();
            System.out.println(String.join(",", lottoNumbers.toString()));
        }
    }

    public static void printTicketAmount(int purchaseAmount) {
        System.out.printf("%n%d개를 구매했습니다.%n", purchaseAmount);
    }

    public static void printProfitRate(float profitRate) {
        String printFormat = "총 수익률은 %.2f 입니다.%n";
        if (profitRate < 1f) {
            printFormat = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n";
        }
        System.out.printf(printFormat, profitRate);
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println("\n당첨 통계\n---------");

        for (LottoRank rank : winningResult.getKeys()) {
            String printFormat = "%d개 일치 (%d원) - %d개%n";
            System.out.printf(printFormat, rank.getMatchCount(), rank.getPrizeMoney(), winningResult.findMatchCount(rank));
        }
    }

    public static void printErrorMessage(String message) {
        System.out.println("Error : " + message);
    }
}
