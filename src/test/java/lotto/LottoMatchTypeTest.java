package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTypeTest {

    @Test
    void 매치시_5개_일치의경우_보너스볼_여부에_따라_승진시킨다() {
        LottoMatchType lottoMatchType = LottoMatchType.FIVE;

        assertThat(lottoMatchType.promotionBonusBall(true)).isSameAs(LottoMatchType.FIVE_BONUS);
        assertThat(lottoMatchType.promotionBonusBall(false)).isSameAs(LottoMatchType.FIVE);
    }
}