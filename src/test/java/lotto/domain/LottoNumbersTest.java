package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.common.Messages.LOTTO_NUMBERS_DUPLICATE;
import static lotto.common.Messages.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoNumbersTest {

    @Test
    void 로또_번호_생성정보_검증() {
        LottoNumbers numbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        assertThat(numbers.getLottoNumbers()).size().isEqualTo(6);
    }

    @Test
    void 로또_번호를_초과한_경우() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)
        );

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers(lottoNumbers))
                .withMessageContaining(LOTTO_NUMBERS_SIZE);
    }

    @Test
    void 동일한_로또_번호가_존재하는지_확인() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(3),
                new LottoNumber(3),
                new LottoNumber(7)
        );

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers(lottoNumbers))
                .withMessageContaining(LOTTO_NUMBERS_DUPLICATE);
    }

    @Test
    void 로또_번호가_당첨_번호와_동일한_번호_검증() {
        LottoNumbers numbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(12),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        LottoNumbers lastWeekWinningNumber = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        assertThat(numbers.containsCount(lastWeekWinningNumber)).isEqualTo(5);
    }
}
