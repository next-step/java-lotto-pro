package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void NULL이나_빈_스트링은_0으로_처리() {
        Number nullNumber = Number.valueOf(null);
        Number emptyNumber = Number.valueOf("");
        assertThat(nullNumber).isEqualTo(Number.valueOf("0"));
        assertThat(emptyNumber).isEqualTo(Number.valueOf("0"));
    }

    @ParameterizedTest(name = "음수나_숫자가_아닌_형식은_예외처리")
    @ValueSource(strings = {"-1", "일", "ONE"})
    void 음수나_숫자가_아닌_형식은_예외처리(String str) {
        assertThatThrownBy(() -> Number.valueOf(str))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 두개의_숫자를_더한다() {
        Number first = Number.valueOf("3");
        Number second = Number.valueOf("2");

        assertThat(first.plus(second)).isEqualTo(Number.valueOf("5"));
    }
}
