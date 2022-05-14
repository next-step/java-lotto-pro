package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasedLottosTest {
    private PurchasedLottos purchasedLottos;

    @BeforeEach
    public void beforeEach() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12));
        purchasedLottos = new PurchasedLottos(lottoList);
    }

    @Test
    void 로또_전체_비교_랭킹_개수_찾기() {
        List<Ranking> rankings = purchasedLottos.compareLottos(new Lotto(1, 2, 3, 4, 5, 6));

        long firstRankingCount = rankings.stream()
                .filter(rank -> rank == Ranking.FIRST)
                .count();
        assertThat(firstRankingCount).isEqualTo(1);

        long fourthRankingCount = rankings.stream()
                .filter(ranking -> ranking == Ranking.FOURTH)
                .count();
        assertThat(fourthRankingCount).isEqualTo(2);
    }
}
