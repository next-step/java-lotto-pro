package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RewardsTest {
    private Rewards rewards;

    @BeforeEach
    void setUp() {
        rewards = new Rewards(Arrays.asList(Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS, Rank.FIFTH));
    }

    @Test
    void 등수별_갯수_반환() {
        assertThat(rewards.count(Rank.FIFTH)).isEqualTo(1);
        assertThat(rewards.count(Rank.MISS)).isEqualTo(4);
    }

    @Test
    void 수익률_계산() {
        assertThat(rewards.calculateRateOfReturn()).isEqualTo(1.0);
    }
}
