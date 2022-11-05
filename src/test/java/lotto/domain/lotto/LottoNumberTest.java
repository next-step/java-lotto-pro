package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest(name = "숫자는 1에서 45 사이여야 한다. value=[{0}]")
    @ValueSource(ints = {0, 46})
    void 숫자_유효성(final int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(value))
                .withMessageContaining("숫자는 1에서 45 사이여야 합니다.");
    }

    @DisplayName("순서와 상관없이 들어있는 숫자 목록이 같으면 동일하다.")
    @Test
    void 동일성() {
        final LottoNumber one = new LottoNumber(1);
        final LottoNumber another = new LottoNumber(1);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("정수로 변환할 수 있다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + " 로또 번호 [{0}]")
    @ValueSource(ints = {1, 6, 45})
    void 정수값(final int value) {
        final LottoNumber lottoNumber = new LottoNumber(value);

        assertThat(lottoNumber.toInt()).isEqualTo(value);
    }
}
