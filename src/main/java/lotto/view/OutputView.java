package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import static lotto.domain.LottoResult.MIN_WINNING_NUM;
import static lotto.util.ProfitCalculator.PRIZE_MONEY;

public class OutputView {

    private static final String OUT_MESSAGE_LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final String OUT_MESSAGE_RESULT_STATISTICS = "당첨 통계";
    private static final String OUT_MESSAGE_DIVIDER_LINE = "----------";
    private static final String OUT_MESSAGE_LOTTO_RESULT = "%d개 일치(%d)- %d개\n";
    private static final String OUT_MESSAGE_PROFIT_RATIO = "총 수익률은 %.2f 입니다.";
    private static final String OUT_MESSAGE_PROFIT_LESS_THAN_EVEN_POINT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int EVEN_POINT_PROFIT_RATIO = 1;

    public static void printLottos(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoAmount(int lottoAmount) {
        System.out.println(lottoAmount + OUT_MESSAGE_LOTTO_AMOUNT);
    }

    public static void printLottoResult(LottoResult lottoResult, double profitRatio) {
        System.out.println(OUT_MESSAGE_RESULT_STATISTICS);
        System.out.println(OUT_MESSAGE_DIVIDER_LINE);
        printLottoStatistics(lottoResult);
        printLottoProfitRatio(profitRatio);
    }

    private static void printLottoStatistics(LottoResult lottoResult) {
        for (int i = MIN_WINNING_NUM; i < PRIZE_MONEY.length; i++) {
            System.out.printf(OUT_MESSAGE_LOTTO_RESULT, i, PRIZE_MONEY[i], lottoResult.getLottoResult(i));
        }
    }

    private static void printLottoProfitRatio(double profitRatio) {
        System.out.printf(OUT_MESSAGE_PROFIT_RATIO, profitRatio);
        if (profitRatio < EVEN_POINT_PROFIT_RATIO) {
            System.out.println(OUT_MESSAGE_PROFIT_LESS_THAN_EVEN_POINT);
        }
    }
}
