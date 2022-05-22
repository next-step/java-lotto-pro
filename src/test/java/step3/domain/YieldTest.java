package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YieldTest {
    @DisplayName("Yield 생성")
    @Test
    void create() {
        assertThat(new Yield(50.5)).isEqualTo(new Yield(50.5));
    }
}