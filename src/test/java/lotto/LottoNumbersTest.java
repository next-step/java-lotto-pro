package lotto;

import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    @Test
    void 번호_포함_여부() {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.contains(LottoNumber.from(1))).isTrue();
    }

    @Test
    void 당첨_번호에게_로또_번호_6개가_동일한지_물어보기() {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers winningNumber = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber.countHit(lottoNumbers)).isEqualTo(FIRST.getCountOfMatch());
    }

    @Test
    void 당첨_번호에게_로또_번호_3개가_동일한지_물어보기() {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers winningNumber = LottoNumbers.from(Arrays.asList(1, 2, 3, 40, 50, 60));
        assertThat(winningNumber.countHit(lottoNumbers)).isEqualTo(FIFTH.getCountOfMatch());
    }

    @Test
    void 로또_번호_출력() {
        assertThat(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)).toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 몇등인지_물어보기() {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers winningNumber = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.getRank(winningNumber, LottoNumber.from(7))).isEqualTo(FIRST);
    }
}