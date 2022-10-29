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
        LottoNumbers lottoNumbers = LottoNumbers.of(new MockNumberGenerator(
                new HashSet<>(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ))
        ));

        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
    }

    @Test
    @DisplayName("로또 숫자가 6개가 아닐 경우 예외 발생")
    void lotto_numbers_is_not_six_throw_exception() {
        assertThatThrownBy(() -> LottoNumbers.of(new MockNumberGenerator(
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
        assertThatThrownBy(() -> LottoNumbers.of(new ManualNumberGenerator("1,1,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복 된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("구매 내역 출력 포맷 [1, 2, 3, 4, 5, 6]")
    void lotto_lottery_print_format() {
        LottoNumbers lottoNumbers = LottoNumbers.of(new ManualNumberGenerator("6,2,3,4,5,1"));
        assertThat(lottoNumbers.history()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
