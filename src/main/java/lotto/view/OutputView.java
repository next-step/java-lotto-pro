package lotto.view;

import lotto.domain.LottoScore;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.TotalLotto;

import java.util.Map;

import static lotto.domain.Rank.*;

public class OutputView {
    private static final String QUANTITY = "개를 구매하였습니다.";
    private static final String LOTTO_STATISTIC_START = "\n당첨 통계\n---------";
    private static final String PROFIT = "총 이익률은 %.2f 입니다.";
    public static void printQuantity(TotalLotto totalLotto) {
        System.out.println(totalLotto.getCount() + QUANTITY);
        System.out.println(totalLotto.lottoListToString());
    }

    public static void printLottoStatistic(LottoScore lottoScore) {
        Map<Rank, Integer> map = lottoScore.getLottoScore();
        System.out.println(LOTTO_STATISTIC_START);
        System.out.println(FIFTH.toString(map.get(Rank.FIFTH)));
        System.out.println(FOURTH.toString(map.get(Rank.FOURTH)));
        System.out.println(THIRD.toString(map.get(Rank.THIRD)));
        System.out.println(SECOND.toString(map.get(Rank.SECOND)));
        System.out.println(FIRST.toString(map.get(Rank.FIRST)));
    }

    public static void printProfit(LottoScore lottoScore, Money money) {
        double profit = lottoScore.calculatorProfit(money.getAmount());
        System.out.println(String.format(PROFIT, profit));
    }
}
