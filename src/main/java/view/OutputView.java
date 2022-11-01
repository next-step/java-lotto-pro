package view;

import domain.Lotto;
import domain.WinLotto;
import domain.WinReport;

import java.util.List;

public class OutputView {
    private static final int[] PRIZE_MONEY = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private static final int WIN_MIN_NUMBER = 3;
    private static final int LOTTO_PRICE = 1000;

    public static void outputCountLottoTicket(int lottoTicketCount) {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    public static void outputPurchaseLottoList(List<Lotto> lottolist) {
        for (Lotto lotto : lottolist) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void outputReportStart() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

    public static void MatchReportResult(WinLotto winLotto) {
        WinReport winReport = winLotto.getWinLottoReport();
        for (int i = WIN_MIN_NUMBER; i < PRIZE_MONEY.length; i++) {
            System.out.printf("%d개 일치(%d)- %d개\n", i, PRIZE_MONEY[i], winReport.getLottoResult(i));

        }
    }

    public static void outputProfit(WinLotto winLotto, int lottoTicketCount) {
        WinReport winReport = winLotto.getWinLottoReport();
        double profit = 0;
        for (int i = WIN_MIN_NUMBER; i < PRIZE_MONEY.length; i++) {
            profit += winReport.getLottoResult(i) * PRIZE_MONEY[i];
        }
        profit = Math.floor(profit / (lottoTicketCount * LOTTO_PRICE) * 100) / 100;

        System.out.printf("총 수익률은 %.2f 입니다.", profit);

        if (profit < 1) {
            System.out.println("기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
    }

}
