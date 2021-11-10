package study.lotto.auto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void trimTest() {
        assertThat("  1, 2,3 ,5 ".trim()).isNotEqualTo("1,2,3,5");
    }
}