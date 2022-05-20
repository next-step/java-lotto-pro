package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RewardTest {
    @Test
    void 숫자_세개_일치() {
        assertThat(Reward.findAmount(3)).isEqualTo(5000);
    }

    @Test
    void 숫자_네개_일치() {
        assertThat(Reward.findAmount(4)).isEqualTo(50000);
    }

    @Test
    void 숫자_다섯개_일치() {
        assertThat(Reward.findAmount(5)).isEqualTo(1500000);
    }

    @Test
    void 숫자_여섯개_일치() {
        assertThat(Reward.findAmount(6)).isEqualTo(2000000000);
    }

    @Test
    void 숫자_일치_예외() {
        assertThatCode(() -> Reward.findAmount(0))
                .isInstanceOf(NoSuchElementException.class);
    }
}