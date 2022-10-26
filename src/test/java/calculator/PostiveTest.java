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

    @Test
    void 합산_테스트() {
        Positive one = new Positive(1);
        Assertions.assertThat(one.sum(new Positive(2))).isEqualTo(new Positive(3));
    }

    @Test
    void 문자열_생성자_사용_가능() {
        Assertions.assertThat(new Positive("1")).isEqualTo(new Positive(1));
    }
}
