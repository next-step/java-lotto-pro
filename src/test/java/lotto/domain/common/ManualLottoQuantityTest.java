package lotto.domain.common;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ManualLottoQuantityTest {

    @Test
    void 수동_로또_개수는_음수_불가() {
        assertThatThrownBy(
                () -> {
                    ManualLottoQuantity.from(-1);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
