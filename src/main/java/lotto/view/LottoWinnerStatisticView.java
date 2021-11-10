package lotto.view;

import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

public class LottoWinnerStatisticView {

    private LottoWinnerStatisticView() {
    }

    public static void print(WinningResult winningResult, Money money) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원) - %d개%n", winningResult.winnerPerRank(Rank.FOURTH_PLACE));
        System.out.printf("4개 일치 (50000원) - %d개%n", winningResult.winnerPerRank(Rank.THIRD_PLACE));
        System.out.printf("5개 일치 (1500000원) - %d개%n", winningResult.winnerPerRank(Rank.SECOND_PLACE));
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원) - %d개%n", winningResult.winnerPerRank(Rank.BONUS_SECOND_PLACE));
        System.out.printf("6개 일치 (2000000000원) - %d개%n", winningResult.winnerPerRank(Rank.FIRST_PLACE));
        System.out.printf("총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임) %n", winningResult.profitRate(money));
    }
}
