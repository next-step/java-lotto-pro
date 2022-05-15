package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PositiveNumberTest {
    @Test
    @DisplayName("0~9 사이의 숫자가 생성된다.")
    void checkPositiveNumber() {
        assertAll(
                () -> assertThat(new PositiveNumber("0").getPositiveNumber()).isEqualTo(0),
                () -> assertThat(new PositiveNumber("3").getPositiveNumber()).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("음수 혹은 숫자가 아닐 경우 IllegalArgumentException 이 발생한다.")
    void checkException() {
        assertAll(
                () -> assertThatThrownBy(() -> {
                    new PositiveNumber("-3");
                }).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> {
                    new PositiveNumber("@");
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
