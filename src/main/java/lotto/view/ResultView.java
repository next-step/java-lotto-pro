package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoReport;
import lotto.domain.Player;

public class ResultView {
    private static final String WINNER_REPORT = "당첨 통계";
    private static final String WINNER_REPORT_PATTERN = "%d개 일치 (%d원)- %d개\n";
    private static final String LINE = "---------";
    private static final String YILELD_REPORT_PATTERN = "총수익률은 %.2f 입니다.";
    private static final String YILELD_BENEFIT_MESSAGE = "(기준이 1이기 때문에 이익이라는 의미)";
    private static final String YILELD_LOSS_MESSAGE = "(기준이 1이기 때문에 이익이라는 의미)";

    public static void createLotto(Player player) {
        List<Lotto> lottos = player.getLottos();
        System.out.println(lottos.size() + "를 구매했습니다.");

        printLotto(lottos);
    }

    public static void winnerReport(LottoReport lottoReport) {
        System.out.println(WINNER_REPORT);
        System.out.println(LINE);

        LottoRank.winnerRanks()
                .forEach((lottoRank -> System.out.printf(WINNER_REPORT_PATTERN,
                        lottoRank.getMatchCount(),
                        lottoRank.rewordMoney(),
                        lottoReport.lottoResultCount(lottoRank))));

        lottoYieldReport(lottoReport);
    }

    private static void lottoYieldReport(LottoReport lottoReport) {
        System.out.printf(YILELD_REPORT_PATTERN, lottoReport.yield());
        if (lottoReport.isBenefit()) {
            System.out.println(YILELD_BENEFIT_MESSAGE);
            return;
        }
        System.out.println(YILELD_LOSS_MESSAGE);
    }

    private static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
