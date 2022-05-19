package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteriesTest {
    @Test
    void 로또_생성_예외() {
        assertThatThrownBy(() -> new Lotteries(null)).isInstanceOf(NullPointerException.class);
    }
}