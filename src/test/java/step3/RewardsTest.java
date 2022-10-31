package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Rank;
import step3.domain.Rewards;

public class RewardsTest {
    private Rewards rewards;

    @BeforeEach
    void setUp() {
        rewards = new Rewards(Arrays.asList(Rank.NOTHING, Rank.NOTHING, Rank.NOTHING, Rank.NOTHING, Rank.FOURTH));
    }

    @Test
    @DisplayName("등수 별로 몇개가 있는지 확인하는 테스트")
    void cntRewards() {
        assertThat(rewards.count(Rank.FOURTH)).isEqualTo(1);
        assertThat(rewards.count(Rank.NOTHING)).isEqualTo(4);
    }

    @Test
    @DisplayName("수익률을 계산하는 테스트")
    void caculateProfit() {
        assertThat(rewards.calculateRateOfReturn()).isEqualTo(1.0);
    }

}
