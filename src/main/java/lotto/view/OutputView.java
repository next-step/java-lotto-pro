package lotto.view;

import lotto.domain.LottoStatistic;

public class OutputView {
    private static final String QUANTITY = "개를 구매하였습니다.";
    private static final String LOTTO_STATISTIC_START = "\n당첨 통계\n---------\n";
    private static final String INPUT_ERROR = "잘못된 값을 입력하였습니다.";

    public static void printQuantity(int n) {
        System.out.println(n + QUANTITY);
    }

    public static void printLottoStatistic(LottoStatistic lottoStatistic) {
        System.out.println(LOTTO_STATISTIC_START);
        System.out.println(lottoStatistic.toResultString());
    }

    public static void printErrorMessage() {
        System.out.println(INPUT_ERROR);
    }
}
