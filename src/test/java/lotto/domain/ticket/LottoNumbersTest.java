package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @DisplayName("정적팩토리 메서드를 이용하여 메서드를 생성하면 객체가 만들어진다.")
    @Test
    void createTest() {
        assertThat(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6))).isInstanceOf(LottoNumbers.class);
    }

    @DisplayName("숫자 콜렉션이 null이면 예외를 던진다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> LottoNumbers.from(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 콜렉션의 크기가 6개가 아니면 받으면 예외를 던진다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("contains메서드에 인자에 포함되는 객체를 인자로 입력하여 호출하면, 참을 반환한다.")
    @Test
    void containsTest1() {
        assertThat(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)).contains(LottoNumber.from(1))).isEqualTo(true);
    }

    @DisplayName("contains메서드에 인자에 포함되지 않는 객체를 인자로 입력하여 호출하면, 거짓을 반환한다.")
    @Test
    void containsTest2() {
        assertThat(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)).contains(LottoNumber.from(7))).isEqualTo(false);

    }
}
