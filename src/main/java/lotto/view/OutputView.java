package lotto.view;

import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

public class OutputView {

    private static final String OUT_MESSAGE_RESULT_STATISTICS = "당첨 통계";
    private static final String OUT_MESSAGE_DIVIDER_LINE = "----------";
    private static final String OUT_MESSAGE_LOTTO_RESULT = "%d개 일치 (%d원)- %d개\n";
    private static final String OUT_MESSAGE_LOTTO_BONUS_RESULT = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String OUT_MESSAGE_PROFIT_RATIO = "총 수익률은 %s 입니다.";
    private static final String OUT_MESSAGE_PROFIT_LESS_THAN_EVEN_POINT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String OUT_MESSAGE_LOTTO_AMOUNT = "수동으로 %d장, 자동으로 %d장을 구매했습니다.\n";
    private static final String ASK_MESSAGE_USER_WRITTEN_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final BigDecimal EVEN_POINT_PROFIT_RATIO = new BigDecimal(1);
    private static final int PROFIT_RATIO_DECIMAL_POINT = 2;
    private static final int MIN_USER_WRITTEN_LOTTO_AMOUNT = 0;

    public static void printLottos(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult(LottoResult lottoResult, int lottoAmount) {
        System.out.println(OUT_MESSAGE_RESULT_STATISTICS);
        System.out.println(OUT_MESSAGE_DIVIDER_LINE);
        printLottoStatistics(lottoResult);
        printLottoProfitRatio(lottoResult.calculateProfitRatio(lottoAmount));
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

    private static void printLottoProfitRatio(BigDecimal profitRatio) {
        System.out.printf(OUT_MESSAGE_PROFIT_RATIO, profitRatio.setScale(PROFIT_RATIO_DECIMAL_POINT, RoundingMode.DOWN));
        if (profitRatio.compareTo(EVEN_POINT_PROFIT_RATIO) < 0) {
            System.out.println(OUT_MESSAGE_PROFIT_LESS_THAN_EVEN_POINT);
        }
    }

    public static void printLottoAmount(int userWrittenLottoCount, int autoLottoCount) {
        System.out.printf(OUT_MESSAGE_LOTTO_AMOUNT, userWrittenLottoCount, autoLottoCount);
    }

    public static void printUserWrittenLotto(int userWrittenLottoAmount) {
        if (userWrittenLottoAmount > MIN_USER_WRITTEN_LOTTO_AMOUNT) {
            System.out.println(ASK_MESSAGE_USER_WRITTEN_LOTTO_NUMBERS);
        }
    }
}
