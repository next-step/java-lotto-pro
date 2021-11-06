package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("1에서 45사이의 번호 하나를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 6, 7, 45})
    void testCreateLottoNumber(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber.value()).isEqualTo(number);
    }

    @DisplayName("1미만 45 초과의 번호를 생성하면 오류가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void testOutOfLengthLottoNumber(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1에서 45 사이의 숫자를 입력하세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ", " 2 ", " 41"})
    void testStringConstructor(String text) {
        LottoNumber lottoNumber = new LottoNumber(text);
        assertThat(lottoNumber.value()).isEqualTo(Integer.parseInt(text.trim()));
    }
}
