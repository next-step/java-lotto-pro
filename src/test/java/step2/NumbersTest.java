package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NumbersTest {
    @DisplayName("문자열_배열이_입력되면_각각_객체가_생성된다")
    @Test
    void 문자열_배열이_입력되면_각각_객체가_생성된다() {
        String[] inputNumberTexts = new String[]{"1", "2", "3"};
        List<Number> numbers = new Numbers(inputNumberTexts).numbers();
        assertAll(
                () -> assertThat(numbers.get(0)).isEqualTo(new Number("1")),
                () -> assertThat(numbers.get(1)).isEqualTo(new Number("2")),
                () -> assertThat(numbers.get(2)).isEqualTo(new Number("3"))
        );
    }

    @DisplayName("빈값이_입력되면_에러를_반환_한다")
    @Test
    void 빈값이_입력되면_에러를_반환_한다() {
        String[] inputNumberTexts = new String[]{};
        assertThatThrownBy(() -> new Numbers(inputNumberTexts))
                .isInstanceOf(RuntimeException.class);
    }
}
