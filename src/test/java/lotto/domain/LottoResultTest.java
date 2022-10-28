package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 상금에따라_카운트를_증가시킨다() {
        LottoResult result = new LottoResult();
        Prize prize = Prize.FIRST;
        result.putPrize(prize);
        result.putPrize(prize);
        assertThat(result.getCount(prize)).isEqualTo(2);
        assertThat(result.matches(prize.getMatchCount())).isEqualTo(2);
    }

    @Test
    void 수익률_계산() {
        LottoResult result = new LottoResult();
        result.putPrize(Prize.FOURTH);
        result.putPrize(Prize.NOTHING);
        result.putPrize(Prize.NOTHING);
        result.putPrize(Prize.NOTHING);
        result.putPrize(Prize.NOTHING);
        result.putPrize(Prize.NOTHING);
        result.putPrize(Prize.NOTHING);
        assertThat(result.calculateRateOfReturn()).isEqualTo((float)5000 / 7000);
    }
}