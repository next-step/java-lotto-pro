package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {

    private static final int TOTAL_WINNING_COUNT = 10;
    private static final int COUNT_OF_MATCH = 3;
    private static final long MONEY_PER_MATCH_COUNT = 5000L;
    private static final Money payment = Money.generate(1000000L);

    private final List<Rank> ranks = Stream.iterate(COUNT_OF_MATCH, countOfMatch -> countOfMatch)
            .map(Rank::valueOf)
            .limit(TOTAL_WINNING_COUNT)
            .collect(Collectors.toList());

    @Test
    @DisplayName("당첨 결과 조회")
    public void testGetStatistics() {
        Reward reward = generateTestReward();
        Rank rank = Rank.valueOf(COUNT_OF_MATCH);
        int rankCount = reward.getRankCount(rank);
        assertThat(rankCount).isEqualTo(TOTAL_WINNING_COUNT);
    }

    private Reward generateTestReward() {
        return Reward.generate(ranks);
    }
}
