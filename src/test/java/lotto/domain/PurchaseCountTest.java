package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseCountTest {

    @Test
    void 음수() {
        // given
        int count = -1;

        // when, then
        assertThatThrownBy(() -> new PurchaseCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 갯수는 0개 이상이어야 합니다. (입력값: " + count + ")");
    }
}