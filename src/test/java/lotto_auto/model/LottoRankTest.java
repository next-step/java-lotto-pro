package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoRankTest {
    @Test
    void 매치_카운트와_보너스볼_매치에_따른_랭크_얻기() {
        LottoRank rank = LottoRank.getLottoRuleFromMatchedCount(3, false);
        assertAll(
            () -> assertThat(LottoRank.getLottoRuleFromMatchedCount(6, false)).isEqualTo(LottoRank.FIRST),
            ()-> assertThat(LottoRank.getLottoRuleFromMatchedCount(5, true)).isEqualTo(LottoRank.SECOND),
            () -> assertThat(LottoRank.getLottoRuleFromMatchedCount(5, false)).isEqualTo(LottoRank.THIRD),
            () -> assertThat(LottoRank.getLottoRuleFromMatchedCount(3, false)).isEqualTo(LottoRank.FIFTH),
            () -> assertThat(LottoRank.getLottoRuleFromMatchedCount(0, false)).isEqualTo(LottoRank.NOTHING)
        );

    }
}
