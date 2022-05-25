package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {
    private static final String BUY_COUNT_MESSAGE = "%s개를 구매 했습니다.";
    private static final String STATISTIC_MESSAGE = "\n당첨 통계";
    private static final String LINE_MESSAGE = "---------";
    private static final String YIELD_MESSAGE = "총 수익률은 %s입니다";
    private static final String PRINT_DELIMITER = ",";
    private static final String PRINT_PREFIX = "[";
    private static final String PRINT_SUFFIX = "]";
    private static final String EACH_PRIZE_MESSAGE = "%s개%s 일치 (%s원)- %s개";
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String EMPTY = "";


    public static void resultBuyCount(final int count) {
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

    public static void printEachPrize(final Map<Prize, Long> rankCount) {
        statisticMessage();
        rankCount.forEach((key, value) -> System.out.println(printPrize(key, value)));
    }

    private static String printPrize(Prize prize, Long count) {
        return String.format(EACH_PRIZE_MESSAGE, prize.getMatchCount(),
                bonusPrize(prize), NumberFormat.getInstance().format(prize.getPrize()), count);
    }

    private static String bonusPrize(Prize prize) {
        if (prize == Prize.BONUS_PLACE) {
            return BONUS_MESSAGE;
        }
        return EMPTY;
    }

    public static void statisticMessage() {
        System.out.println(STATISTIC_MESSAGE);
        System.out.println(LINE_MESSAGE);
    }

    public static void resultYield(float yield) {
        System.out.printf((YIELD_MESSAGE) + "%n", yield);
    }
}
