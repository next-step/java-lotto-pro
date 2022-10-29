package step3.view;

import step3.model.Award;
import step3.model.Lotto;
import step3.model.LottoPaper;
import step3.model.WinningReport;
import step3.model.WinningResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void announceTotalLottoTicketCount(int countOfLotto) {
        System.out.println(countOfLotto + "개를 구매했습니다.");
    }

    public static void announceTotalLottoNumbers(LottoPaper lottoPaper) {
        List<Lotto> lottos = lottoPaper.getLottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void resultStart() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void WinningResult(WinningResult winningResult) {
        WinningReport winningReport = winningResult.winningReport();
        Map<Award, Integer> awardResult = winningReport.awardResult();
        Arrays.stream(Award.values())
            .filter(award -> !award.equals(Award.MISS))
            .forEach(award ->
                System.out.println(award.countOfMatch() + "개 일치 " +
                    "(" + award.winningMoney() + "원)- " +
                    awardResult.getOrDefault(award, 0) + "개"
                )
            );

        System.out.println("총 수익률은 " + winningReport.rateOfReturn() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
