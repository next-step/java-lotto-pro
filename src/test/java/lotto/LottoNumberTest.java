package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 숫자 테스트")
class LottoNumberTest {

    @DisplayName("생성 성공 - 문자열을 인자로 받는 생성자")
    @Test
    void createByString_lottoNumber_success() {
        assertThatNoException().isThrownBy(() -> new LottoNumber("12"));
    }

    @DisplayName("숫자 값 반환 성공")
    @Test
    void getIntValue_lottoNumber_success() {
        //given:
        LottoNumber lottoNumber = new LottoNumber("12");
        //when, then:
        assertThat(lottoNumber.getIntNumber()).isEqualTo(12);
    }

    @DisplayName("숫자 값 반환 실패 - 문자열이 포함 된 값")
    @Test
    void getIntValue_lottoNumber_NumberFormatException() {
        assertThatThrownBy(() -> new LottoNumber("1a")).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("숫자 값 반환 실패 - 로또 숫자 범위를 벗어난 값")
    @Test
    void getIntValue_lottoNumber_IllegalArgumentException() {
        assertThatThrownBy(() -> new LottoNumber("46")).isInstanceOf(IllegalArgumentException.class);
    }
}
