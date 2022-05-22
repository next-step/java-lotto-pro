package lotto.view;

import lotto.domain.LottoScore;
import lotto.domain.Rank;
import lotto.domain.TotalLotto;

import java.util.Map;

import static lotto.constants.Message.*;
import static lotto.domain.Rank.*;

public class OutputView {
    public static void printQuantity(TotalLotto totalLotto) {
        System.out.println(totalLotto.getCount() + QUANTITY);
        System.out.println(totalLotto.lottoListToString());
    }

    public static void printLottoStatistic(Map<Rank, Integer> map) {
        System.out.println(LOTTO_STATISTIC_START);
        System.out.println(FIFTH.toString(map.get(Rank.FIFTH)));
        System.out.println(FOURTH.toString(map.get(Rank.FOURTH)));
        System.out.println(THIRD.toString(map.get(Rank.THIRD)));
        System.out.println(SECOND.toString(map.get(Rank.SECOND)));
        System.out.println(FIRST.toString(map.get(Rank.FIRST)));
    }

    public static void printProfit(double profit) {
        System.out.println(String.format(PROFIT, profit));
    }

    public static void printErrorMessage() {
        System.out.println(INPUT_AMOUNT_ERROR);
    }
}
