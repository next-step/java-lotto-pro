package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @DisplayName("정적팩토리 메서드를 이용하여 숫자로 된 문자열을 받으면 객체를 생성한다.")
    @Test
    void createTest1() {
        assertThat(LottoNumber.from("1")).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("정적팩토리 메서드를 이용하여 숫자를 받으면 객체를 생성한다.")
    @Test
    void createTest2() {
        assertThat(LottoNumber.from(1)).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("객체 생성시 범위를 벗어나는 값을 받으면 예외를 던진다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> LottoNumber.from(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.from(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("객체 생성시 null또는 빈문자열 값을 받으면 예외를 던진다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> LottoNumber.from("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.from(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
