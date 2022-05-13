package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    private final LottoNumber lottoNumber = new LottoNumber(10);

    @DisplayName("1보다 작거나 45보다 큰 숫자는 IllegalArgumentException 예외")
    @ParameterizedTest(name = "1보다 작거나 45보다 큰 숫자{0}는 IllegalArgumentException 예외")
    @ValueSource(strings = {"-1", "0", "47", "1000"})
    void lottoNotMinMaxRange(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(input))
                .withMessage("로또 숫자 범위가 아닙니다.");
    }

    @DisplayName("로또 초기화 테스트")
    @Test
    void lotto() {
        assertThat(new LottoNumber(10)).isEqualTo(lottoNumber);
    }
}
