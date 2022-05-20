package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class ResultView {
    private static final String LOTTO_AMOUNT_MESSAGE = "\n수동으로 %d개, 자동으로 %d개를 구매했습니다.\n";
    private static final String GAME_RESULT_MESSAGE = "\n당첨 통계\n---------";
    private static final String GAME_STATISTICS_MESSAGE = "%s개 일치 (%s원) - %d개\n";
    private static final String GAME_BONUS_STATISTICS_MESSAGE = "%s개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String BENEFIT_MESSAGE = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
    private static final String DIS_BENEFIT_MESSAGE = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void printGameStart(final int countOfManualLotto, final int countOfAutoLotto, final List<Lotto> userLotto) {
        System.out.printf(LOTTO_AMOUNT_MESSAGE, countOfManualLotto, countOfAutoLotto);
        for (Lotto lotto : userLotto) {
            System.out.println(lotto.toString());
        }
    }

    public void printGameResult(final Map<Rank, Long> gameResult) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (Rank result : gameResult.keySet()) {
            printStatisticResult(result, gameResult.get(result));
        }
    }

    public void printBenefitResult(final double benefit, final double referenceValue) {
        if (benefit >= referenceValue) {
            System.out.printf(BENEFIT_MESSAGE, benefit);
            return;
        }
        System.out.printf(DIS_BENEFIT_MESSAGE, benefit);
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    private void printStatisticResult(final Rank result, final long matchResult) {
        if (result == Rank.SECOND) {
            System.out.printf(GAME_BONUS_STATISTICS_MESSAGE,
                    result.getCountOfMatch(), result.getWinningMoney(), matchResult);
            return;
        }
        System.out.printf(GAME_STATISTICS_MESSAGE,
                result.getCountOfMatch(), result.getWinningMoney(), matchResult);
    }
}
