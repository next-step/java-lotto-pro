package stringaddcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputStringTest {

    @Test
    void 기본_구분자로_숫자를_구분한다() {
        assertThat(new InputString("1,2").getNumbers()).containsExactly(1, 2);
        assertThat(new InputString("1:2").getNumbers()).containsExactly(1, 2);
    }
}
