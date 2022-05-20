package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {
    private static final String BUY_COUNT_MESSAGE = "%s개를 구매 했습니다.";
    private static final String RESULT_LOTTO_MESSAGE = "%s개 일치(%s)- %s개";
    private static final String STATISTIC_MESSAGE = "\n당첨 통계";
    private static final String LINE_MESSAGE = "---------";
    private static final String YIELD_MESSAGE = "총 수익률은 %s입니다";
    private static final String PRINT_DELIMITER = ",";
    private static final String PRINT_PREFIX = "[";
    private static final String PRINT_SUFFIX = "]";


    public static void resultBuyCount(final long count) {
        System.out.printf((BUY_COUNT_MESSAGE) + "%n", count);
    }

    public static void printLottoNumber(final List<Lotto> lottoes) {
        for (Lotto lotto : lottoes) {
            String printLotto = lotto.getLottoNumber().stream()
                    .map(LottoNumber::getValue)
                    .map(Objects::toString)
                    .collect(Collectors.joining(PRINT_DELIMITER, PRINT_PREFIX, PRINT_SUFFIX));

            System.out.println(printLotto);
        }
    }

    public static void resultLotto(final long matchCount, final long prize, final long count) {
        System.out.printf((RESULT_LOTTO_MESSAGE) + "%n", matchCount, prize, count);
    }

    public static void statisticMessage() {
        System.out.println(STATISTIC_MESSAGE);
        System.out.println(LINE_MESSAGE);
    }

    public static void resultYield(float yield) {
        System.out.printf((YIELD_MESSAGE) + "%n", yield);
    }
}
