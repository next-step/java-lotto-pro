package lotto.domain.common;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoQuantityTest {

    @Test
    void 수동로또는_전체_로또_개수를_넘어갈수_없다() {
        assertThatThrownBy(
                () -> {
                    LottoQuantity.of(TotalLottoQuantity.from(5),
                            ManualLottoQuantity.from(6));
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
