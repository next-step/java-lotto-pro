package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private OutputView() {}

    public static void printGetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");

        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.toString());
        }

        System.out.println();
    }

    public static void printWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printStatistics(Map<Rank, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : statistics.keySet()) {
            System.out.printf("%d개 일치 (%d원) - %d개\n",
                    rank.getMatchCount(), rank.getMoneyValue(), statistics.get(rank));
        }
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.2f입니다.", returnRate);
    }
}
