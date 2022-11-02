package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.Arrays;

public class OutputView {
    private static final String MSG_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String MSG_CORRECT_COUNT = "%d개 일치";
    private static final String MSG_BONUS = ", 보너스 볼 일치";
    private static final String MSG_PRIZE = " (%d원)- %d개";
    private static final String MSG_RETURN_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OutputView() {

    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printLottoCount(int manualCount, int autoCount) {
        print(String.format(MSG_LOTTO_COUNT, manualCount, autoCount - manualCount));
    }

    public static void printResult(LottoResult result) {
        print("당첨 통계");
        print("---------");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> print(generateResultMessage(rank, result.getRankCount(rank))));
        print(String.format(MSG_RETURN_RATE, result.getReturnRate()));
    }

    private static String generateResultMessage(Rank rank, int count) {
        return String.format(MSG_CORRECT_COUNT, rank.getMatchCount()) +
                generateBonusMessage(rank) +
                String.format(MSG_PRIZE, rank.getPrize(), count);
    }

    private static String generateBonusMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return MSG_BONUS;
        }
        return "";
    }
}
