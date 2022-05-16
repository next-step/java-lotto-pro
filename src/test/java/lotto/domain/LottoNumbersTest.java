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
    void 로또_숫자들에서_오름차순으로_정렬된_로또_번호_6개를_생성할_수_있다() {
        assertThat(lottoNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:7:FIRST",
            "1,2,3,4,5,8:6:SECOND",
            "1,2,3,4,5,8:45:THIRD",
            "1,2,3,4,8,9:6:FOURTH",
            "1,2,3,8,9,10:6:FIFTH",
            "1,2,7,8,9,10:6:NONE",
            "1,7,8,9,10,11:6:NONE",
            "7,8,9,10,11,12:6:NONE"
    }, delimiter = ':')
    void 당첨번호를_통해_당첨결과를_계산할_수_있다(String stringNumbers, Integer bonusNumber, String stringWinningRank) {
        List<Integer> numbers = StringUtils.convertToList(stringNumbers, ",");
        WinningRank expected = WinningRank.valueOf(stringWinningRank);
        assertThat(lottoNumbers.matchWinningNumbers(numbers, bonusNumber)).isEqualTo(expected);
    }
}
