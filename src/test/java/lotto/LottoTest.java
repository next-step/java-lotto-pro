package lotto;

import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    void 번호_포함_여부() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(LottoNumber.from(1))).isTrue();
    }

    @Test
    void 당첨_번호에게_로또_번호_6개가_동일한지_물어보기() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber.countHit(lotto)).isEqualTo(FIRST.getCountOfMatch());
    }

    @Test
    void 당첨_번호에게_로또_번호_3개가_동일한지_물어보기() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = Lotto.from(Arrays.asList(1, 2, 3, 40, 41, 42));
        assertThat(winningNumber.countHit(lotto)).isEqualTo(FIFTH.getCountOfMatch());
    }

    @Test
    void 로또_번호_출력() {
        assertThat(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)).toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 몇등인지_물어보기() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getRank(winningNumber, LottoNumber.from(7))).isEqualTo(FIRST);
    }
}