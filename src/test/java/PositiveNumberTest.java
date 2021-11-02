import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {
    @DisplayName("정적팩토리 메서드를 이용하여 문자열 숫자를 인자로 받으면 객체를 생성한다.")
    @Test
    void createTest() {
        assertThat(PositiveNumber.from("1")).isInstanceOf(PositiveNumber.class);
    }

    @DisplayName("add함수 호출하면 두수를 더한 값을 가지는 객체를 생성한다.")
    @Test
    void addTest() {
        assertThat(PositiveNumber.from("1").add(PositiveNumber.from("2"))).isEqualTo(PositiveNumber.from("3"));
    }

    @DisplayName("정적팩토리 메서드의 인자에 허용되지 않는 음수값을 받으면 예외를 던진다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> PositiveNumber.from("-1")).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("정적팩토리 메서드의 인자에 허용되지 않는 숫자가 아닌 문자열을 받으면 예외를 던진다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> PositiveNumber.from("chang")).isInstanceOf(RuntimeException.class);
    }
}
