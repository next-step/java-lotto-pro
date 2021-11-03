package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {

    @Test
    void 구입금액을_생성한다() {
        assertThat(new Purchase(1000)).isEqualTo(new Purchase(1000));
    }
}