package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    @Test
    void 번호_포함_여부() {
        LottoNumbers lottoNumbers = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumbers.contains(1)).isTrue();
    }

    @Test
    void 보너스_번호_포함_여부() {
        LottoNumbers lottoNumbers = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers winningNumber = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        assertThat(winningNumber.containsBonus(lottoNumbers)).isFalse();
    }

    @Test
    void 당첨_번호에게_로또_번호_6개가_동일한지_물어보기() {
        LottoNumbers lottoNumbers = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers winningNumber = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winningNumber.countHit(lottoNumbers)).isEqualTo(6);
    }

    @Test
    void 당첨_번호에게_로또_번호_3개가_동일한지_물어보기() {
        LottoNumbers lottoNumbers = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 10, 20, 30)));
        LottoNumbers winningNumber = new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winningNumber.countHit(lottoNumbers)).isEqualTo(3);
    }

    @Test
    void 로또_번호_출력() {
        assertThat(new LottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))).toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]");
    }
}