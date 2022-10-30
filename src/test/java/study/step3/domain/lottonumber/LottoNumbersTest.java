package study.step3.domain.lottonumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.utils.LottoNumbersGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 컬렉션 생성시 6개의 로또 번호가 주어지지 않으면 [IllegalArgumentException] 예외처리 한다")
    void create_with_greater_than_six_lotto_number_test() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(12),
                new LottoNumber(23),
                new LottoNumber(33),
                new LottoNumber(44),
                new LottoNumber(45),
                new LottoNumber(43)
        );

        assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumberMessage.ERROR_SHOULD_BE_GIVEN_SIX_LOTTO_NUMBERS.message());
    }

    @Test
    @DisplayName("로또 번호 컬렉션 생성시 중복 된 로또 번호가 있으면 [IllegalArgumentException] 예외처리 한다")
    void create_with_duplicated_lotto_number_test() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(12),
                new LottoNumber(23),
                new LottoNumber(33),
                new LottoNumber(44),
                new LottoNumber(44)
        );
        assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumberMessage.ERROR_SHOULD_BE_NOT_DUPLICATED_LOTTO_NUMBER.message());
    }

    @Test
    @DisplayName("다른 로또 번호를 비교하여 일치하는 번호 갯수를 반환한다")
    void match_with_winnings_lotto_numbers_test() {
        LottoNumbers lottoNumbers = LottoNumbersGenerator.createLottoNumbers(1, 12, 22, 33, 44, 45);
        LottoNumbers winningsLottoNumbers = LottoNumbersGenerator.createLottoNumbers(1, 12, 22, 33, 32, 31);
        long matchCount = lottoNumbers.match(winningsLottoNumbers);
        assertThat(matchCount).isEqualTo(4);
    }
}
