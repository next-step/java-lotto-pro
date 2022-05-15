package lotto.domain;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers((list) -> Collections.swap(list, 0, 1));
    }

    @Test
    void 로또_숫자들에서_오름차순으로_정렬된_로또_번호_6개_및_보너스볼을_생성할_수_있다() {
        assertThat(lottoNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottoNumbers.getBonusNumber()).isEqualTo(7);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,7,8:THIRD", "1,2,3,7,8,9:FOURTH", "1,2,7,8,9,10:NONE", "1,7,8,9,10,11:NONE", "7,8,9,10,11,12:NONE"}, delimiter = ':')
    void 당첨번호를_통해_당첨결과를_계산할_수_있다(String stringNumbers, String stringWinningRank) {
        List<Integer> numbers = StringUtils.convertToList(stringNumbers, ",");
        WinningRank expected = WinningRank.valueOf(stringWinningRank);
        assertThat(lottoNumbers.matchWinningNumbers(numbers)).isEqualTo(expected);
    }
}
