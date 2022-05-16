package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NonAutoPurchaseCountTest {

    @Test
    void nonAutoPurchasePrice() {
        assertThat(new NonAutoPurchaseCount(3)
                .nonAutoPurchasePrice())
                .isEqualTo(3000);
    }
}