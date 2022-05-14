package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ZeroOrPositiveNumberTest {

    @Test
    public void 유효하지_않은_입력값_문자() {
        assertThatThrownBy(() -> new ZeroOrPositiveNumber("d"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 유효하지_않은_입력값_음수() {
        assertThatThrownBy(() -> new ZeroOrPositiveNumber(-1))
                .isInstanceOf(RuntimeException.class);
    }
}
