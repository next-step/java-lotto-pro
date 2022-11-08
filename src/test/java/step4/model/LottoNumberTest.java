package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.LottoFormatException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또_숫자_원시값_WRAPPING_클래스")
public class LottoNumberTest {
    @DisplayName("Number_정상_입력")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "45:45"}, delimiter = ':')
    void Number_pass_01(String text, int expectedNumber) {
        LottoNumber lottoNumber = LottoNumber.valueOf(text);
        assertThat(LottoNumber.valueOf(expectedNumber)).isEqualTo(lottoNumber);
        assertThat(LottoNumber.valueOf(expectedNumber) == lottoNumber).isTrue();
    }

    @DisplayName("Number_숫자_아니면_에러")
    @ParameterizedTest
    @ValueSource(strings = {",", "a", "a1", ""})
    void Number_fail_01(String text) {
        assertThatThrownBy(() -> LottoNumber.valueOf(text))
                .isInstanceOf(LottoFormatException.class);
    }

    @DisplayName("Number_숫자_1_45_범위_밖이면_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void Number_fail_02(String text) {
        assertThatThrownBy(() -> LottoNumber.valueOf(text))
                .isInstanceOf(LottoFormatException.class);
    }


    @DisplayName("Number_숫자_equal_test")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "45:45:true", "1:45:false"}, delimiter = ':')
    void Number_equal_test_01(String num, String otherNum, boolean expected) {
        LottoNumber number = LottoNumber.valueOf(num);
        LottoNumber otherNumber = LottoNumber.valueOf(otherNum);
        assertThat(number.equals(otherNumber)).isEqualTo(expected);
    }
}
