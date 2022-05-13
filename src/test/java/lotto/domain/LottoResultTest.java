package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    public void 로또_결과_조회_테스트() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12));
        MyLotto myLotto = new MyLotto(lottoList);

        LottoResult result = new LottoResult(myLotto.compareLottos(new Lotto(1, 2, 3, 4, 5, 6)));
        List<Ranking> firstRankings = result.findRankings(6);
        assertThat(firstRankings).hasSize(1);

        List<Ranking> fourthRankings = result.findRankings(3);
        assertThat(fourthRankings).hasSize(2);
    }

}