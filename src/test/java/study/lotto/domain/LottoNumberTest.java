package study.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest(name = "로또 번호 {0}")
    @ValueSource(ints = {1, 45})
    @DisplayName("로또 번호는 1부터 45의 숫자만 허용한다.")
    void 유효한_로또번호(int lottoNumber) {
        assertThat(new LottoNumber(lottoNumber)).isNotNull();
    }

    @ParameterizedTest(name = "로또 번호 {0}")
    @ValueSource(ints = {-1, 46})
    @DisplayName("로또 번호가 1부터 45의 숫자가 아니면 IllegalArgumentException 를 발생시킨다.")
    void 무효한_로또번호(int lottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("번호 동등 확인")
    class 번호_동등_확인 {
        private final LottoNumber lottoNumber = new LottoNumber(10);

        @Test
        @DisplayName("입력된 숫자가 로또번호와 같으면 true를 반환한다.")
        void 번호_동등() {
            assertThat(lottoNumber.hasNumber(10)).isTrue();
        }

        @Test
        @DisplayName("입력된 숫자가 로또번호와 다르면 false를 반환한다.")
        void 번호_상이() {
            assertThat(lottoNumber.hasNumber(1)).isFalse();
        }
    }
}
