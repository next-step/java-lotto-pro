package model;

import model.strategy.MockStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static model.LottoRankType.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 당첨번호_결과통계를_보여준다_보너스번호미포함() {
        int count = new Money(1000).availableBuyAutoLottoCount(0);
        int bonusNumber = 20;
        Lottos lottos = new Lottos(Collections.emptyList(),
                new Seller().buyAuto(count, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)))
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 9, 10);

        Rank rank = new Rank();
        rank.stats(lottos, winNumber, bonusNumber);

        assertThat(rank.getCountRank().get(RANK_ONE)).isZero();
        assertThat(rank.getCountRank().get(RANK_TWO)).isZero();
        assertThat(rank.getCountRank().get(RANK_THREE)).isZero();
        assertThat(rank.getCountRank().get(RANK_FOUR)).isEqualTo(1);
        assertThat(rank.getCountRank().get(RANK_FIVE)).isZero();
    }

    @Test
    void 당첨번호_결과통계를_보여준다_보너스번호포함() {
        int count = new Money(1000).availableBuyAutoLottoCount(0);
        int bonusNumber = 6;
        Lottos lottos = new Lottos(Collections.emptyList(),
                new Seller().buyAuto(count, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)))
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 10);

        Rank rank = new Rank();
        rank.stats(lottos, winNumber, bonusNumber);

        assertThat(rank.getCountRank().get(RANK_ONE)).isZero();
        assertThat(rank.getCountRank().get(RANK_TWO)).isEqualTo(1);
        assertThat(rank.getCountRank().get(RANK_THREE)).isZero();
        assertThat(rank.getCountRank().get(RANK_FOUR)).isZero();
        assertThat(rank.getCountRank().get(RANK_FIVE)).isZero();
    }
}