package lotto.view;

import lotto.prize.Prize;
import lotto.prize.Prizes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class OutputView {
    private static final String SIZE_FORMAT = "%s개를 구매했습니다.";
    private static final String PRIZE_DEFUALT_FORMAT = "%s개 일치 (%s원) - %s개";
    private static final String PRIZE_SECOND_FORMAT = "%s개 일치 (%s원),보너스 볼 일치- %s개";
    private static final String YIELD_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoCount(int count) {
        System.out.println(String.format(SIZE_FORMAT, count));
    }

    public static void printLottos(String text) {
        System.out.println(text);
    }

    public static void printStatistic(Prizes prizes, BigDecimal yield) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(convertStatisticResult(prizes, yield));
    }

    private static String convertStatisticResult(Prizes prizes, BigDecimal yield) {
        String statistic = Arrays.stream(Prize.values())
                .sorted(Comparator.comparing(Prize::getPrizeMoney))
                .filter(v -> v != Prize.MISS)
                .map(v ->
                        String.format(convertPrizeCountText(v), v.getMatchCount(), v.getPrizeMoney(), prizes.countMatchPrize(v)))
                .collect(Collectors.joining("\n"));
        String convertYield = String.format(YIELD_FORMAT, yield);
        return String.join("\n", statistic, convertYield);
    }

    private static String convertPrizeCountText(Prize prize) {
        if (prize == Prize.SECOND) {
            return PRIZE_SECOND_FORMAT;
        }
        return PRIZE_DEFUALT_FORMAT;
    }


}
