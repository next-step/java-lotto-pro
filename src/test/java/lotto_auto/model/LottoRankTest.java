package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    void 매치_카운트에_따른_랭크_얻기() {
        LottoRank rank = LottoRank.getLottoRuleFromMatchedCount(3);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 로또_비교후_결과_랭크() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");

        assertThat(LottoRank.matches(lotto, winningLotto)).isEqualTo(LottoRank.FIRST);
    }
}
