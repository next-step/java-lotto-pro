package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.WinningStatistics;

public class ResultView {

    public static void purchaseLottoResult(int autoLottoCount, List<Lotto> lottoList) {
        System.out.println(autoLottoCount + "개를 구매했습니다.");
        lottoNumberResult(lottoList);
    }

    private static void lottoNumberResult(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().getValues());
        }
    }

    public static void winningResult(WinningStatistics winningStatistics) {
        System.out.println("당첨통계");
        System.out.println("---------");
        HashMap<LottoRanking, Integer> winningStatistic = winningStatistics.getLottoRankingCount();
        for (LottoRanking lottoRanking : winningStatistic.keySet()) {
            statisticsResult(lottoRanking, winningStatistic);
        }
    }

    private static void statisticsResult(LottoRanking lottoRanking,
        HashMap<LottoRanking, Integer> winningStatistic) {
        if (!lottoRanking.equals(LottoRanking.MISS)) {
            System.out.println(lottoRanking.getMatchingNumber() +
                "개 일치 " + "(" + lottoRanking.getWinAmount() + "원) - "
                + winningStatistic.get(lottoRanking) + "개");
        }
    }

    public static void yieldResult(double lottoYield) {
        System.out.print("총 수익률은 " + lottoYield + "입니다.");
        if (lottoYield < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (lottoYield >= 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이득라는 의미임)");
        }
    }
}
