package stringaddcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputStringTest {

    @Test
    void 기본_구분자로_숫자를_구분한다() {
        assertThat(new InputString("1,2").getNumbers()).containsExactly(1, 2);
        assertThat(new InputString("1:2").getNumbers()).containsExactly(1, 2);
    }

    @Test
    void 빈문자열_또는_null인_경우에는_0을_반환() {
        assertThat(new InputString("").getNumbers()).containsExactly(0);
        assertThat(new InputString(null).getNumbers()).containsExactly(0);
    }
}
