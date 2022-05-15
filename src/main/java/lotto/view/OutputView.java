package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.enums.LottoWinningType;

public class OutputView {
    public static void printPurchasedLottos(Lottos lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printWinningCount(result);
        printProfitRate(result);
    }

    private static void printWinningCount(LottoResult result) {
        System.out.println(String.format("3개 일치 (5000원)- %d개",
                result.getWinningCountByWinningType(LottoWinningType.FOURTH)));
        System.out.println(String.format("4개 일치 (50000원)- %d개",
                result.getWinningCountByWinningType(LottoWinningType.THIRD)));
        System.out.println(String.format("5개 일치 (1500000원)- %d개",
                result.getWinningCountByWinningType(LottoWinningType.SECOND)));
        System.out.println(String.format("6개 일치 (2000000000원)- %d개",
                result.getWinningCountByWinningType(LottoWinningType.FIRST)));
    }

    private static void printProfitRate(LottoResult result) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", result.getProfitRate()));
    }
}
