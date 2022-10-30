package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 상금에따라_카운트를_증가시킨다() {
        LottoResult result = new LottoResult();
        Rank rank = Rank.FIRST;
        result.addCount(rank);
        result.addCount(rank);
        assertThat(result.getCount(rank)).isEqualTo(2);
        assertThat(result.matches(rank.getCountOfMatch())).isEqualTo(2);
    }

    @Test
    void 수익률_계산() {
        LottoResult result = new LottoResult();
        result.addCount(Rank.FOURTH);
        result.addCount(Rank.MISS);
        result.addCount(Rank.MISS);
        result.addCount(Rank.MISS);
        result.addCount(Rank.MISS);
        result.addCount(Rank.MISS);
        result.addCount(Rank.MISS);
        assertThat(result.calculateRateOfReturn()).isEqualTo((float)Rank.FOURTH.getWinningMoney() / 7000);
    }
}