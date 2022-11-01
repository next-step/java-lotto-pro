package view;

import domain.*;

public class OutputView {

    private static final int WIN_MIN_NUMBER = 3;
    private static final int WIN_MAX_NUMBER = 6;

    public static void outputCountLottoTicket(int lottoTicketCount) {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    public static void outputPurchaseLottoList(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void outputReportStart() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

    public static void MatchReportResult(WinLotto winLotto) {
        WinReport winReport = winLotto.getWinLottoReport();

        for (int i = WIN_MIN_NUMBER; i < WIN_MAX_NUMBER; i++) {
            System.out.printf("%d개 일치(%d)- %d개\n", i, PrizeMoney.valueOf(i).prizeMoney(), winReport.getLottoResult(i));

        }
    }

    public static void outputProfit(WinLotto winLotto, int lottoTicketCount) {
        WinReport winReport = winLotto.getWinLottoReport();
        double profit = winReport.calculateProfit(lottoTicketCount);

        System.out.printf("총 수익률은 %.2f 입니다.", profit);

        if (profit < 1) {
            System.out.println("기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
    }

}
