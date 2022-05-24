package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ManualLottosTest {
    @Test
    void 구매할_로또_수와_실제_입력_개수_다를경우_예외() {
        assertThatThrownBy(() -> ManualLottos.of(1, new String[]{"1,2,3,4,5,6", "1,2,3,4,5,7"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}