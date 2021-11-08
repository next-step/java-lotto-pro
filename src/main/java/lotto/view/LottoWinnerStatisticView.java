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
        System.out.println("3개 일치 (5000원) - " + winningResult.winnerPerRank(Rank.FOURTH_PLACE));
        System.out.println("4개 일치 (50000원) - " + winningResult.winnerPerRank(Rank.THIRD_PLACE));
        System.out.println("5개 일치 (1500000원) - " + winningResult.winnerPerRank(Rank.SECOND_PLACE));
        System.out.println("6개 일치 (2000000000원) - " + winningResult.winnerPerRank(Rank.FIRST_PLACE));
        System.out.println(String.format("총 수익률은 %s 입니다.", winningResult.profitRate(money)));
    }
}
