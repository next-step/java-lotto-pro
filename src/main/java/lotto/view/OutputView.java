package lotto.view;

import lotto.domain.LottoStatistic;
import lotto.domain.TotalLotto;

import java.util.Map;

import static lotto.domain.LottoStatistic.*;

public class OutputView {
    private static final String QUANTITY = "개를 구매하였습니다.";
    private static final String LOTTO_STATISTIC_START = "\n당첨 통계\n---------";
    private static final String LOTTO_MATCH = "개 일치";
    private static final String INPUT_ERROR = "잘못된 값을 입력하였습니다.";
    private static final String PROFIT = "총 이익률은 %.2f 입니다.";

    public static void printQuantity(TotalLotto totalLotto) {
        System.out.println(totalLotto.getCount() + QUANTITY);
        System.out.println(totalLotto.lottoListToString());
    }

    public static void printLottoStatistic(Map<LottoStatistic, Integer> map) {
        System.out.println(LOTTO_STATISTIC_START);
        System.out.println(THREE_WINNING_AMOUNT.toString(map.get(LottoStatistic.THREE_WINNING_AMOUNT)));
        System.out.println(FOUR_WINNING_AMOUNT.toString(map.get(LottoStatistic.FOUR_WINNING_AMOUNT)));
        System.out.println(FIVE_WINNING_AMOUNT.toString(map.get(LottoStatistic.FIVE_WINNING_AMOUNT)));
        System.out.println(SIX_WINNING_AMOUNT.toString(map.get(LottoStatistic.SIX_WINNING_AMOUNT)));
    }

    public static void printProfit(double profit) {
        System.out.println(String.format(PROFIT, profit));
    }

    public static void printErrorMessage() {
        System.out.println(INPUT_ERROR);
    }
}
