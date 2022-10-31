package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호는 6개")
    void lotto_size_is_six() {
        LottoNumbers lottoNumbers = LottoNumbers.of(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
    }

    @Test
    @DisplayName("로또 숫자가 6개가 아닐 경우 예외 발생")
    void lotto_numbers_is_not_six_throw_exception() {
        assertThatThrownBy(() -> LottoNumbers.of(new ManualNumberGenerator("1, 2, 3, 4, 5")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개 입니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 입력 될 경우 예외 발생")
    void duplicate_input_number_throw_exception() {
        assertThatThrownBy(() -> LottoNumbers.of(new ManualNumberGenerator("1, 1, 3, 4, 5, 6")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복 된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 있는지 확인")
    void check_duplicate_number_lotto_numbers() {
        LottoNumbers lottoNumbers = LottoNumbers.of(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        assertAll(
                () -> assertTrue(lottoNumbers.isContainNumber(new LottoNumber(1))),
                () -> assertFalse(lottoNumbers.isContainNumber(new LottoNumber(8))));
    }

    @Test
    @DisplayName("구매 내역 출력 포맷 [1, 2, 3, 4, 5, 6]")
    void lotto_lottery_print_format() {
        LottoNumbers lottoNumbers = LottoNumbers.of(new ManualNumberGenerator("6,2,3,4,5,1"));
        assertThat(lottoNumbers.history()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6/1, 2, 3, 4, 5, 6/6",
            "1, 2, 3, 4, 5, 6/1, 2, 3, 4, 5, 7/5",
            "1, 2, 3, 4, 5, 6/1, 2, 3, 4, 7, 8/4",
            "1, 2, 3, 4, 5, 6/1, 2, 3, 7, 8, 9/3",
            "1, 2, 3, 4, 5, 6/1, 2, 7, 8, 9, 10/2",
            "1, 2, 3, 4, 5, 6/1, 7, 8, 9, 10, 11/1",
            "1, 2, 3, 4, 5, 6/7, 8, 9, 10, 11, 12/0",
    }, delimiter = '/')
    @DisplayName("로또 번호 일치 개수 반환")
    void lotto_number_match(String originNumbers, String compareNumbers, int expect) {
        LottoNumbers lottoNumbers = LottoNumbers.of(new ManualNumberGenerator(originNumbers));
        assertThat(lottoNumbers.containCount(LottoNumbers.of(new ManualNumberGenerator(compareNumbers)))).isEqualTo(expect);
    }
}
