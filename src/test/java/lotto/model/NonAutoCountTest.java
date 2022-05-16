package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NonAutoCountTest {

    @Test
    void nonAutoPurchasePrice() {
        assertThat(new NonAutoCount(3)
                .nonAutoPurchasePrice())
                .isEqualTo(3000);
    }
}