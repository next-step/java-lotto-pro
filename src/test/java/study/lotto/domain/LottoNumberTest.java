package study.lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
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
}
