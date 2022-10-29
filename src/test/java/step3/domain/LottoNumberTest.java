package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {


    @DisplayName("로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 25, 45})
    void 로또번호_생성(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("로또번호 생성 예외 테스트 1~45 이외 숫자")
    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    void 로또번호_예외(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
