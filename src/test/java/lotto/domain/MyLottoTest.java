package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoTest {
    @Test
    void 나의_로또_생성() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(13, 14, 15, 16, 17, 18));
        MyLotto myLotto = new MyLotto(lottoList);
        assertThat(myLotto.getLottoList()).hasSize(lottoList.size());
    }

    @Test
    void 나의_로또_전체_비교() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12));
        MyLotto myLotto = new MyLotto(lottoList);

        List<Ranking> rankings = myLotto.compareLottos(new Lotto(1, 2, 3, 4, 5, 6));
        assertThat(rankings).hasSize(lottoList.size());

        long firstRankCount = rankings.stream()
                .filter(rank -> rank == Ranking.FIRST)
                .count();
        assertThat(firstRankCount).isEqualTo(1);

        long fourthRankCount = rankings.stream()
                .filter(ranking -> ranking == Ranking.FOURTH)
                .count();
        assertThat(fourthRankCount).isEqualTo(2);
    }
}