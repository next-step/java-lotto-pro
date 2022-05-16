package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {


    @DisplayName("해당하는 Reward 에 해당하는 개수를 응답한다.")
    @Test
    void count() {
        Rewards rewards = new Rewards(List.of(Reward.FIRST, Reward.MISS));
        assertThat(rewards.count(Reward.FIRST)).isEqualTo(1);
        assertThat(rewards.count(Reward.SECOND)).isZero();
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateYield() {
        Rewards rewards = new Rewards(List.of(
                Reward.FOURTH,
                Reward.MISS
        ));
        assertThat(rewards.calculateRateOfReturn()).isEqualTo(1.5);
    }

}
