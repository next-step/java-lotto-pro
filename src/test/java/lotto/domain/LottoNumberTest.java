package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "2:1:1", "1:2:-1"}, delimiter = ':')
    @DisplayName("로또 번호 비교 체크")
    void compareTo(int number1, int number2, int expected) {
        LottoNumber lottoNumber1 = new LottoNumber(number1);
        LottoNumber lottoNumber2 = new LottoNumber(number2);
        assertThat(lottoNumber1.compareTo(lottoNumber2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또 번호가 범위를 벗어났을 경우 Exception 발생 확인")
    void validateRange(int number) {
        assertThatThrownBy(() -> {
            new LottoNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
