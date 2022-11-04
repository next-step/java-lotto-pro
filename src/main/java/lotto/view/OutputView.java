package lotto.view;

import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.Arrays;
import java.util.Comparator;

public class OutputView {

    private static final String OUT_MESSAGE_LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final String OUT_MESSAGE_RESULT_STATISTICS = "당첨 통계";
    private static final String OUT_MESSAGE_DIVIDER_LINE = "----------";
    private static final String OUT_MESSAGE_LOTTO_RESULT = "%d개 일치 (%d원)- %d개\n";
    private static final String OUT_MESSAGE_LOTTO_BONUS_RESULT = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
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
        Arrays.stream(Rank.values())
                .sorted(Comparator.comparingInt(Rank::getWinningMoney))
                .filter(Rank::isWinner)
                .forEach(rank -> System.out.printf(makeLottoResultMessage(rank)
                        , rank.getCountOfMatch()
                        , rank.getWinningMoney()
                        , lottoResult.getLottoResult().getOrDefault(rank, 0)));
    }

    private static String makeLottoResultMessage(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return OUT_MESSAGE_LOTTO_BONUS_RESULT;
        }
        return OUT_MESSAGE_LOTTO_RESULT;
    }

    private static void printLottoProfitRatio(double profitRatio) {
        System.out.printf(OUT_MESSAGE_PROFIT_RATIO, profitRatio);
        if (profitRatio < EVEN_POINT_PROFIT_RATIO) {
            System.out.println(OUT_MESSAGE_PROFIT_LESS_THAN_EVEN_POINT);
        }
    }
}
