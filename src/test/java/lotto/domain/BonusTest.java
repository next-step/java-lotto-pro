package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusTest {

    @Test
    void 보너스_숫자를_생성한다() {
        assertThat(new Bonus("1")).isEqualTo(new Bonus("1"));
    }
}