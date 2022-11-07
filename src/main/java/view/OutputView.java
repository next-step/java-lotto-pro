package view;

import domain.*;
import java.util.Arrays;
import java.util.Comparator;

public class OutputView {

    public static void outputCountLottoTicket(int lottoTicketCount, int manualLottoTicketCount) {
        int autoTicketCount = lottoTicketCount - manualLottoTicketCount;

        if (manualLottoTicketCount > 0) {
            System.out.print("수동으로 " + manualLottoTicketCount + "장,");
        }
        System.out.println("자동으로 " + autoTicketCount + "장");
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

    public static void MatchReportResult(WinReport winReport) {
        Arrays.stream(PrizeMoney.values())
                .sorted(Comparator.comparingInt(PrizeMoney::getPrizeMoney))
                .filter(prizeMoney -> prizeMoney.getCollectCount() > 2)
                .forEach(prizeMoney -> System.out.printf(makeLottoResuiltMessage(prizeMoney)
                        , prizeMoney.getCollectCount()
                        , prizeMoney.getPrizeMoney()
                        , winReport.getLottoResult(prizeMoney)));
    }

    public static String makeLottoResuiltMessage(PrizeMoney prizeMoney) {
        if (prizeMoney.isSecondPlace(prizeMoney)) {
            return "%d개 일치, 보너스 볼 일치(%d)- %d개\n";
        }
        return "%d개 일치(%d)- %d개\n";
    }

    public static void outputProfit(WinReport winReport, int lottoTicketCount) {
        double profit = winReport.calculateProfit(lottoTicketCount);

        System.out.printf("총 수익률은 %.2f 입니다.", profit);

        if (profit < 1) {
            System.out.println("기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }
    }

}
