package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void 구입금액에_따라_갯수를_계산한다() {
        assertThat(new Money("14000").count()).isEqualTo(14);
        assertThat(new Money("1200").count()).isEqualTo(1);
        assertThat(new Money("1999").count()).isEqualTo(1);
        assertThat(new Money("2000").count()).isEqualTo(2);
        assertThatThrownBy(() -> new Money("900"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Money("0"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Money("-100"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}