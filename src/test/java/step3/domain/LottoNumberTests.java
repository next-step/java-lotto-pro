package step3.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 테스트")
class LottoNumberTests {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호가 1 ~ 45 사이 숫자가 아닐 경우 예외가 발생한다")
    void should_IllegalArgumentException_When_Not_1to45(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(String.format("로또 번호는 1 ~ 45 사이 숫자여야 합니다. (lottoNumber: %s)", number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또 번호가 1 ~ 45 사이 숫자일 경우 생성된다")
    void create(int number) {
        assertThatCode(() -> new LottoNumber(number))
            .doesNotThrowAnyException();
    }
}
