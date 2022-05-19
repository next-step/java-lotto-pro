package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRanking;
import org.junit.jupiter.api.Test;

public class LottoRankingTest {

    private LottoNumbers lottoNumbers = new LottoNumbers(
        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)));

    @Test
    public void findFirstRanking() {
        //given
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(lottoNumbers);
        LottoRanking expectedLottoRanking = LottoRanking.FIRST_PRIZE;
        //when
        LottoRanking actualLottoRanking = LottoRanking.findLottoRaking(lotto, winningLotto);
        //then
        assertThat(actualLottoRanking).isEqualTo(expectedLottoRanking);
    }

    @Test
    public void findSecondRanking() {
        //given
        LottoNumbers winningNumbers = new LottoNumbers(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)));
        Lotto winningLotto = new Lotto(winningNumbers);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoRanking expectedLottoRanking = LottoRanking.SECOND_PRIZE;

        //when
        LottoRanking actualLottoRanking = LottoRanking.findLottoRaking(lotto, winningLotto);

        //then
        assertThat(actualLottoRanking).isEqualTo(expectedLottoRanking);
    }

    @Test
    public void findThirdRanking() {
        //given
        LottoNumbers winningNumbers = new LottoNumbers(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(7), new LottoNumber(8)));
        Lotto winningLotto = new Lotto(winningNumbers);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoRanking expectedLottoRanking = LottoRanking.THIRD_PRIZE;

        //when
        LottoRanking actualLottoRanking = LottoRanking.findLottoRaking(lotto, winningLotto);

        //then
        assertThat(actualLottoRanking).isEqualTo(expectedLottoRanking);
    }

    @Test
    public void findFourthRanking() {
        //given
        LottoNumbers winningNumbers = new LottoNumbers(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));
        Lotto winningLotto = new Lotto(winningNumbers);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoRanking expectedLottoRanking = LottoRanking.FOURTH_PRIZE;

        //when
        LottoRanking actualLottoRanking = LottoRanking.findLottoRaking(lotto, winningLotto);

        //then
        assertThat(actualLottoRanking).isEqualTo(expectedLottoRanking);
    }

    @Test
    public void findMissRanking() {
        //given
        LottoNumbers winningNumbers = new LottoNumbers(
            Arrays.asList(new LottoNumber(11), new LottoNumber(21), new LottoNumber(31),
                new LottoNumber(32), new LottoNumber(33), new LottoNumber(34)));
        Lotto winningLotto = new Lotto(winningNumbers);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoRanking expectedLottoRanking = LottoRanking.MISS;

        //when
        LottoRanking actualLottoRanking = LottoRanking.findLottoRaking(lotto, winningLotto);

        //then
        assertThat(actualLottoRanking).isEqualTo(expectedLottoRanking);
    }
}
