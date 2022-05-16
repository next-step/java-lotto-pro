package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    void 매치_카운트에_따른_랭크_얻기() {
        LottoRank rank = LottoRank.getLottoRuleFromMatchedCount(3);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }
}
