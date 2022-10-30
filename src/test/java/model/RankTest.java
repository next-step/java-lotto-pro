package model;

import model.strategy.MockStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static model.LottoRankType.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 당첨번호_결과통계를_보여준다() {
        List<LottoNumber> buyLotto = Arrays.asList(
                new LottoNumber(new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)))
        );
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 9, 10);
        Map<LottoRankType, Integer> countRank = new Rank().stats(buyLotto, winNumber);

        assertThat(countRank.get(RANK_ONE)).isZero();
        assertThat(countRank.get(RANK_TWO)).isZero();
        assertThat(countRank.get(RANK_THREE)).isEqualTo(1);
        assertThat(countRank.get(RANK_FOUR)).isZero();
        assertThat(countRank.get(RANK_FAIL)).isZero();
    }
}