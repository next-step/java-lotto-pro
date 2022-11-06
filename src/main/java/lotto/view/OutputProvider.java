package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.Rewards;

public class OutputProvider {
    private static final String PURCHASE_LOTTO_COUNT = "%d개를 구매하셨습니다.%n";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String BOUNDARY = "---------";
    private static final String FIRST_MATCH_COUNT = "6개 일치 (2000000000원)- %d개\n";
    private static final String SECOND_MATCH_COUNT = "5개 일치, 보너스 볼 일치(30000000원) - %d개\n";
    private static final String THIRD_MATCH_COUNT = "5개 일치 (1500000원)- %d개\n";
    private static final String FOURTH_MATCH_COUNT = "4개 일치 (50000원)- %d개\n";
    private static final String FIFTH_MATCH_COUNT = "3개 일치 (5000원)- %d개\n";
    private static final String TOTAL_RATE_OF_REWARD = "총 수익률은 %.2f입니다.\n";

    public static void printLottoTicket(LottoTickets lottoTickets) {
        System.out.printf(PURCHASE_LOTTO_COUNT, lottoTickets.getTicketCount());
        System.out.println(lottoTickets);
        System.out.println();
    }

    public static void printRewards(Rewards rewards) {
        System.out.println(WINNING_STATS);
        System.out.println(BOUNDARY);
        System.out.printf(FIFTH_MATCH_COUNT, rewards.count(Rank.FIFTH));
        System.out.printf(FOURTH_MATCH_COUNT, rewards.count(Rank.FOURTH));
        System.out.printf(THIRD_MATCH_COUNT, rewards.count(Rank.THIRD));
        System.out.printf(SECOND_MATCH_COUNT, rewards.count(Rank.SECOND));
        System.out.printf(FIRST_MATCH_COUNT, rewards.count(Rank.FIRST));
        System.out.printf(TOTAL_RATE_OF_REWARD, rewards.calculateRateReward());
    }
}
