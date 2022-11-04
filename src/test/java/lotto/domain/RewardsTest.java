package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {
    private Rewards rewards;

    @BeforeEach
    void setUp() {
        rewards = new Rewards(Arrays.asList(Rank.FIFTH, Rank.MISS, Rank.FOURTH, Rank.MISS, Rank.FIFTH));
    }
    @Test
    @DisplayName("등수_개수_반환")
    void 등수_개수_반환() {
        assertThat(rewards.count(Rank.FOURTH)).isEqualTo(1);
        assertThat(rewards.count(Rank.FIFTH)).isEqualTo(2);
        assertThat(rewards.count(Rank.MISS)).isEqualTo(2);
    }
    @Test
    @DisplayName("수익률_반환")
    void 수익률_반환() {
        assertThat(rewards.calculateRateReward()).isEqualTo(12);
    }
}
