package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PositiveNumbersTest {
    @Test
    @DisplayName("빈 문자열 혹은 null이 주어지면 0이 응답된다.")
    void checkZeroResult() {
        assertAll(
                () -> assertThat(new PositiveNumbers("").sum()).isEqualTo(0),
                () -> assertThat(new PositiveNumbers(null).sum()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("기본 구분자인 쉼표(,)와 콜론(:)가 포함된 문자열을 더한다.")
    void checkSumNumbersWithDefaultDelimiters() {
        assertAll(
                () -> assertThat(new PositiveNumbers("1").sum()).isEqualTo(1),
                () -> assertThat(new PositiveNumbers("1,2,3").sum()).isEqualTo(6),
                () -> assertThat(new PositiveNumbers("1:2").sum()).isEqualTo(3),
                () -> assertThat(new PositiveNumbers("1:2,3:4").sum()).isEqualTo(10)
        );
    }

    @Test
    @DisplayName("커스텀 구분자(//커스텀구분자\\n)이 포함된 문자열을 더한다.")
    void checkSumNumbersWithCustomDelimiters() {
        assertAll(
                () -> assertThat(new PositiveNumbers("//-\n1-2-3").sum()).isEqualTo(6),
                () -> assertThat(new PositiveNumbers("//#\n1#2#3").sum()).isEqualTo(6)
        );
    }
}
