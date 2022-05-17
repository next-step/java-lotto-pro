package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRanking;
import org.junit.jupiter.api.Test;

public class LottoRankingTest {

    private LottoNumbers lottoNumbers = new LottoNumbers(
        List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)));

    @Test
    public void findFirstRanking() {
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(lottoNumbers);
        assertThat(LottoRanking.findLottoRaking(lotto, winningLotto)).isEqualTo(
            LottoRanking.FIRST_PRIZE);
    }

    @Test
    public void findSecondRanking() {
        LottoNumbers winningNumbers = new LottoNumbers(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(7)));
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);
        assertThat(LottoRanking.findLottoRaking(lotto, winningLotto)).isEqualTo(
            LottoRanking.SECOND_PRIZE);
    }

    @Test
    public void findThirdRanking() {
        LottoNumbers winningNumbers = new LottoNumbers(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(7), new LottoNumber(8)));
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);
        assertThat(LottoRanking.findLottoRaking(lotto, winningLotto)).isEqualTo(
            LottoRanking.THIRD_PRIZE);
    }

    @Test
    public void findFourthRanking() {
        LottoNumbers winningNumbers = new LottoNumbers(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7),
                new LottoNumber(8), new LottoNumber(9)));
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);
        assertThat(LottoRanking.findLottoRaking(lotto, winningLotto)).isEqualTo(
            LottoRanking.FOURTH_PRIZE);
    }

    @Test
    public void findMissRanking() {
        LottoNumbers winningNumbers = new LottoNumbers(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(7), new LottoNumber(8),
                new LottoNumber(9), new LottoNumber(10)));
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);
        assertThat(LottoRanking.findLottoRaking(lotto, winningLotto)).isEqualTo(
            LottoRanking.MISS);
    }
}
