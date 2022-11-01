package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void 번호_포함_여부() {
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumber.contains(1)).isTrue();
    }

    @Test
    void 보너스_번호_포함_여부() {
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumber winningNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        assertThat(winningNumber.containsBonus(lottoNumber)).isFalse();
    }

    @Test
    void 당첨_번호에게_로또_번호_6개가_동일한지_물어보기() {
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumber winningNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winningNumber.countHit(lottoNumber)).isEqualTo(6);
    }

    @Test
    void 당첨_번호에게_로또_번호_3개가_동일한지_물어보기() {
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 10, 20, 30)));
        LottoNumber winningNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winningNumber.countHit(lottoNumber)).isEqualTo(3);
    }

    @Test
    void 로또_번호_출력() {
        assertThat(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))).toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]");
    }
}