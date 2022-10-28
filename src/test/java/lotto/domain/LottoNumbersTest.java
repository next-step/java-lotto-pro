package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호는 6개")
    void lotto_size_is_six() {
        LottoNumbers lottoNumbers = new LottoNumbers(new MockNumberGenerator(
                new HashSet<>(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ))
        ));

        assertThat(lottoNumbers).isInstanceOf(LottoNumber.class);
    }

    @Test
    @DisplayName("로또 숫자가 6개가 아닐 경우 예외 발생")
    void lotto_numbers_is_not_six_throw_exception() {
        assertThatThrownBy(() -> new LottoNumbers(new MockNumberGenerator(
                new HashSet<>(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5)
                ))
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개 입니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 입력 될 경우 예외 발생")
    void duplicate_input_number_throw_exception() {
        assertThatThrownBy(() -> new LottoNumbers(new ManualNumberGenerator("1,1,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복 된 숫자가 있습니다.");
    }
}