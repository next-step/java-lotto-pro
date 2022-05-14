package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static lotto.WinningRank.FIRST;
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

    @Test
    void 당첨번호를_통해_당첨결과를_계산할_수_있다() {
        Assertions.assertAll(
                () -> assertThat(lottoNumbers.matchWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(FIRST),
                () -> assertThat(lottoNumbers.matchWinningNumbers(Arrays.asList(7, 8, 9, 10, 11, 12))).isNull()
        );
    }
}
