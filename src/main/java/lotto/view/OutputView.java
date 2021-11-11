package lotto.view;

import lotto.domain.LottoReports;
import lotto.domain.LottoTicket;
import lotto.domain.LottoType;
import lotto.domain.Rank;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoTickets(LottoTicket lottoTicket) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다. %n",
            lottoTicket.getCountOfLottoType(LottoType.MANUAL), lottoTicket.getCountOfLottoType(LottoType.AUTO));
        System.out.println(lottoTicket);
    }

    public static void printLottoReports(LottoReports lottoReports) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.printf("%d개 일치 (%d원)- %d개 %n", Rank.FIFTH.getCountOfMatch(),
            Rank.FIFTH.getWinningMoney(), lottoReports.getRankCount(Rank.FIFTH));
        System.out.printf("%d개 일치 (%d원)- %d개 %n", Rank.FOURTH.getCountOfMatch(),
            Rank.FOURTH.getWinningMoney(), lottoReports.getRankCount(Rank.FOURTH));
        System.out.printf("%d개 일치 (%d원)- %d개 %n", Rank.THIRD.getCountOfMatch(),
            Rank.THIRD.getWinningMoney(), lottoReports.getRankCount(Rank.THIRD));
        System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개 %n", Rank.SECOND.getCountOfMatch(),
            Rank.SECOND.getWinningMoney(), lottoReports.getRankCount(Rank.SECOND));
        System.out.printf("%d개 일치 (%d원)- %d개 %n", Rank.FIRST.getCountOfMatch(),
            Rank.FIRST.getWinningMoney(), lottoReports.getRankCount(Rank.FIRST));
        System.out.println("총 수익률은 " + lottoReports.getProfitRatio() + "입니다.");
    }

}
