package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.enums.Rank;
import lotto.domain.dto.StatisticDto;

import java.util.List;

public class ResultView {
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

    public static void printStatistics(StatisticDto dto) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.reverseValues()) {
            int matchCount = rank.getMatchCount();
            System.out.printf("%d개 일치 (%d원) - %d개\n", matchCount, rank.getMoneyValue(), dto.getCount(matchCount));
        }
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.2f입니다.", returnRate);
    }
}
