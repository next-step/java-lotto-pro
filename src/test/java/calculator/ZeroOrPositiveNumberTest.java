package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ZeroOrPositiveNumberTest {

    @Test
    public void 유효하지_않은_숫자하나() {
        assertThatThrownBy(() -> new ZeroOrPositiveNumber("d"))
                .isInstanceOf(RuntimeException.class);
    }

}
