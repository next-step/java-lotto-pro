package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoQuantityTest {

    @Test
    void 로또_수량_오류() {
        assertThatThrownBy(() -> {
            new LottoQuantity(-100);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
