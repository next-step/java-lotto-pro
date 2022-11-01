package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

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
        //given:
        LottoNumber lottoNumber = new LottoNumber("1a");
        //when, then:
        assertThatThrownBy(lottoNumber::getIntNumber).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("숫자 값 반환 실패 - 로또 숫자 범위를 벗어난 값")
    @Test
    void getIntValue_lottoNumber_IllegalArgumentException() {
        //given:
        LottoNumber lottoNumber = new LottoNumber("46");
        //when, then:
        assertThatThrownBy(lottoNumber::getIntNumber).isInstanceOf(IllegalArgumentException.class);
    }

    static List<Number> makeLottoNumbers(List<String> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
