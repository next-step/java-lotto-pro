package lotto.domain;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void 로또_수익률_계산() {
        // given
        Money money = new Money("10000");
        LottoRanks lottoRanks = new LottoRanks(Collections.singletonList(
                LottoRank.THIRD
        ));

        // when
        double earningsRate = LottoResult.lottoGameEarningsRate(money.currentMoney(), lottoRanks);

        // then
        assertThat(earningsRate).isEqualTo(5.0);
    }

    @Test
    void 로또_수익률_계산2() {
        // given
        Money money = new Money("14000");
        LottoRanks lottoRanks = new LottoRanks(Collections.singletonList(
                LottoRank.FOURTH
        ));

        // when
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double earningsRate = LottoResult.lottoGameEarningsRate(money.currentMoney(), lottoRanks);

        // then
        assertThat(decimalFormat.format(earningsRate)).isEqualTo("0.36");
    }
}
