package view;

import domain.*;

import java.util.Arrays;
import java.util.Comparator;

public class OutputView {

    public static void outputCountLottoTicket(int lottoTicketCount) {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    public static void outputPurchaseLottoList(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void outputReportStart() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

    public static void MatchReportResult(WinLotto winLotto) {
        WinReport winReport = winLotto.getWinLottoReport();

        Arrays.stream(PrizeMoney.values())
                .sorted(Comparator.comparingInt(PrizeMoney::getPrizeMoney))
                .filter(prizeMoney -> prizeMoney.getCollectCount() > 2)
                .forEach(prizeMoney -> System.out.printf(makeLottoResuiltMessage(prizeMoney)
                        , prizeMoney.getCollectCount()
                        , prizeMoney.getPrizeMoney()
                        , winReport.getLottoResult(prizeMoney)));
    }

    public static String makeLottoResuiltMessage(PrizeMoney prizeMoney) {
        if (prizeMoney.equals(PrizeMoney.SECOND_PLACE)) {
            return "%d개 일치, 보너스 볼 일치(%d)- %d개\n";
        }
        return "%d개 일치(%d)- %d개\n";
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
