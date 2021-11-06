package lotto.view;

import java.util.List;

import lotto.domain.LottoReports;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
        System.out.println();
    }

    public static void printLottoReports(LottoReports lottoReports) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.printf("%d개 일치 (%d원)- %d개 %n", Rank.FIFTH.getCountOfMatch(),
            Rank.FIFTH.getWinningMoney(), lottoReports.countOfFifty());
        System.out.printf("%d개 일치 (%d원)- %d개 %n", Rank.THIRD.getCountOfMatch(),
            Rank.THIRD.getWinningMoney(), lottoReports.countOfThird());
        System.out.printf("%d개 일치 (%d원)- %d개 %n", Rank.SECOND.getCountOfMatch(),
            Rank.SECOND.getWinningMoney(), lottoReports.countOfSecond());
        System.out.printf("%d개 일치 (%d원)- %d개 %n", Rank.FIRST.getCountOfMatch(),
            Rank.FIRST.getWinningMoney(), lottoReports.countOfFirst());
        System.out.println("총 수익률은 " + lottoReports.profitRatio() + "입니다.");
    }

}
