package step3.view;

import step3.domain.Lottos;
import step3.domain.Rank;
import step3.domain.Rewards;

public class ConsoleOutputView {

    private static final String PURCHASE_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String DIVISION_LINE = "---------";
    private static final String FIFTH_MATCH_COUNT = "3개 일치 (5000원)- %d개%n";
    private static final String FOURTH_MATCH_COUNT = "4개 일치 (50000원)- %d개%n";
    private static final String THIRD_MATCH_COUNT = "5개 일치 (1500000원)- %d개%n";
    private static final String SECOND_MATCH_COUNT = "5개 일치, 보너스 볼 일치(30000000원)- %d개%n";
    private static final String FIRST_MATCH_COUNT = "6개 일치 (2000000000원)- %d개%n";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 %.2f입니다.%n";


    private ConsoleOutputView() {

    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printLottosCount(int manual, int auto) {
        System.out.printf(PURCHASE_LOTTO_COUNT, manual, auto);
    }

    public static void printRewards(Rewards rewards) {
        System.out.println(WINNING_STATS);
        System.out.println(DIVISION_LINE);
        System.out.printf(FIFTH_MATCH_COUNT, rewards.count(Rank.FIFTH));
        System.out.printf(FOURTH_MATCH_COUNT, rewards.count(Rank.FOURTH));
        System.out.printf(THIRD_MATCH_COUNT, rewards.count(Rank.THIRD));
        System.out.printf(SECOND_MATCH_COUNT, rewards.count(Rank.SECOND));
        System.out.printf(FIRST_MATCH_COUNT, rewards.count(Rank.FIRST));
        System.out.printf(TOTAL_RATE_OF_RETURN, rewards.calculateRateOfReturn());
    }
}
