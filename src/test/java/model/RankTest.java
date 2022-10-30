package model;

import model.strategy.MockStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static model.LottoRankType.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 당첨번호_결과통계를_보여준다() {
        List<LottoNumber> buyLotto = Arrays.asList(
                new LottoNumber(new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)).shuffle())
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 9, 10);
        Rank rank = new Rank();

        rank.stats(buyLotto, winNumber);

        assertThat(rank.getCountRank().get(RANK_ONE)).isZero();
        assertThat(rank.getCountRank().get(RANK_TWO)).isZero();
        assertThat(rank.getCountRank().get(RANK_THREE)).isEqualTo(1);
        assertThat(rank.getCountRank().get(RANK_FOUR)).isZero();
    }
}