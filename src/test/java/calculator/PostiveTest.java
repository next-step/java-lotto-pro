package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostiveTest {
    @Test
    void 음수_입력시_에러() {
        Assertions.assertThatThrownBy(() -> new Positive(-1))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("음수는 사용이 불가능");
    }
}
