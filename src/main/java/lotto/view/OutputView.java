package lotto.view;

import lotto.domain.LottoStatistic;

public class OutputView {
    private static final String QUANTITY = "개를 구매하였습니다.";
    private static final String LOTTO_STATISTIC_START = "\n당첨 통계\n---------\n";

    public static void printQuantity(int n) {
        System.out.println(n + QUANTITY);
    }

    public static void printLottoStatistic(LottoStatistic lottoStatistic) {
        System.out.println(LOTTO_STATISTIC_START);
        System.out.println(lottoStatistic.toResultString());
    }
}
