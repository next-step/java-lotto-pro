package lotto;

import lotto.domain.Lotto;
import lotto.domain.TotalLotto;
import org.junit.jupiter.api.Test;
import stringAddCalculator.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TotalLottoTest {
    @Test
    public void 구매한_로또_개수_count() throws IllegalArgumentException {
        TotalLotto totalLotto = new TotalLotto();
        totalLotto.count(14000);
        TotalLotto expectedTrue = new TotalLotto(14);
        assertThat(totalLotto.equals(expectedTrue)).isEqualTo(true);

        TotalLotto expectedFalse = new TotalLotto(20);
        assertThat(totalLotto.equals(expectedFalse)).isEqualTo(false);
    }

    @Test
    public void 구매금액_negative() throws IllegalArgumentException {
        TotalLotto totalLotto = new TotalLotto();
        assertThatThrownBy(() -> totalLotto.count(-14000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 일치하는_수_카운트() {
        String lottoNumber = "1,2,3,4,5,6";
        TotalLotto totalLotto = new TotalLotto();
        Lotto target = new Lotto(lottoNumber);
        totalLotto.winningLotto(lottoNumber);
        assertThat(totalLotto.MatchesLottoNumber(target)).isEqualTo(6);

        target = new Lotto("1,2,3,7,8,9");
        assertThat(totalLotto.MatchesLottoNumber(target)).isEqualTo(3);
    }
}
