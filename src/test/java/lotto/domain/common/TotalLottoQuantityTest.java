package lotto.domain.common;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class TotalLottoQuantityTest {

    @Test
    void 전체_로또_개수는_음수_불가() {
        assertThatThrownBy(
                () -> {
                    TotalLottoQuantity.from(-1);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
