package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.LottoFormatException;
import step3.model.LottoNumber;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또_숫자_원시값_WRAPPING_클래스")
public class LottoNumberTest {
    @DisplayName("Number_정상_입력")
    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void Number_pass_01(String text) {
        assertThatNoException().isThrownBy(() -> new LottoNumber(text));
    }

    @DisplayName("Number_숫자_아니면_에러")
    @ParameterizedTest
    @ValueSource(strings = {",", "a", "a1", ""})
    void Number_fail_01(String text) {
        assertThatThrownBy(() -> new LottoNumber(text))
                .isInstanceOf(LottoFormatException.class);
    }

    @DisplayName("Number_숫자_1_45_범위_밖이면_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void Number_fail_02(String text) {
        assertThatThrownBy(() -> new LottoNumber(text))
                .isInstanceOf(LottoFormatException.class);
    }


    @DisplayName("Number_숫자_equal_test")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "45:45:true", "1:45:false"}, delimiter = ':')
    void Number_equal_test_01(String num, String otherNum, boolean expected) {
        LottoNumber number = new LottoNumber(num);
        LottoNumber otherNumber = new LottoNumber(otherNum);
        assertThat(number.equals(otherNumber)).isEqualTo(expected);
    }
}
